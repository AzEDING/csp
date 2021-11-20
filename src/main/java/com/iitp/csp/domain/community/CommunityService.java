package com.iitp.csp.domain.community;

import com.iitp.csp.domain.community.entity.Community;
import com.iitp.csp.domain.community.entity.CommunityRepository;
import com.iitp.csp.domain.community.entity.dto.CommunityPutReqDto;
import com.iitp.csp.domain.community.entity.dto.CommunityReqDto;
import com.iitp.csp.domain.community.entity.dto.CommunityResDto;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long postCommunity(CommunityReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(() -> new RuntimeException());
        Community community = dto.toEntity();
        community.setMember(member);
        return communityRepository.save(community).getCommunityId();
    }
    @Transactional(readOnly = true)
    public CommunityResDto getCommunity(Long id){
        Community community = communityRepository.findById(id).orElseThrow(()->new RuntimeException("해당게시물없음"));
        return new CommunityResDto(community);
    }
    @Transactional
    public Long putCommunity(Long id, CommunityPutReqDto dto) {
        Community community = communityRepository.findById(id).orElseThrow(()->new RuntimeException("수정게시물없음"));

        community.setCommunity(dto.getTitle(), dto.getContent());
        Community result = communityRepository.save(community);
        return result.getCommunityId();
    }

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Community> getCommunityPage(Pageable page){
        return communityRepository.findAll(page);
    }

}
