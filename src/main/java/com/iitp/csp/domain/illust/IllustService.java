package com.iitp.csp.domain.illust;

import com.iitp.csp.domain.illust.entity.Illust;
import com.iitp.csp.domain.illust.entity.IllustRepository;
import com.iitp.csp.domain.illust.entity.dto.IllustPutReqDto;
import com.iitp.csp.domain.illust.entity.dto.IllustReqDto;
import com.iitp.csp.domain.illust.entity.dto.IllustResDto;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IllustService {
    @Autowired
    private IllustRepository illustRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long postIllust(IllustReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Illust illust = dto.toEntity();
        illust.setMember(member);
        return illustRepository.save(illust).getIllustId();
    }

    @Transactional(readOnly = true)
    public IllustResDto getIllust(Long id){
        Illust illust = illustRepository.findById(id).orElseThrow(()->new RuntimeException("해당게시물없음"));
        return new IllustResDto(illust);
    }

    @Transactional
    public Long putIllust(Long id, IllustPutReqDto dto) {
        Illust illust = illustRepository.findById(id).orElseThrow(()->new RuntimeException("수정게시물없음"));

        illust.setIllust(dto.getTitle(), dto.getContent());
        Illust result = illustRepository.save(illust);
        return result.getIllustId();
    }

    public void deleteIllust(Long id) {
        illustRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Illust> getIllustPage(Pageable page){
        return illustRepository.findAll(page);
    }

}
