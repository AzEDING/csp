package com.iitp.csp.domain.member;

import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import com.iitp.csp.domain.member.entity.dto.MemberPutReqDto;
import com.iitp.csp.domain.member.entity.dto.MemberReqDto;
import com.iitp.csp.domain.member.entity.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Long postMember(MemberReqDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member result = memberRepository.save(dto.toEntity());
        return result.getMemberId();

    }

    public MemberResDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당유저없음"));
        return new MemberResDto(member);
    }

    @Transactional
    public Long putMember(Long id, MemberPutReqDto dto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당유저없음"));

        member.setData(dto.getEmail(), dto.getBirth(), dto.getPhone(), dto.getNickName());
        Member result = memberRepository.save(member);
        return result.getMemberId();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

//     fixme compare password



    @Transactional(readOnly = true)
    public Page<Member> getMemberPage(Pageable page) {
        return memberRepository.findAll(page);
    }

//    public Long loginMember(Long id, MemberLoginReqDto dto) {
//        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당유저없음"));
//
//    }
}

//    Member member = memberRepository.findByEmail(email)
//            .orElseThrow(() -> new UsernameNotFoundException(email));
//    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
//                if (email.equals("sup2is@gmail.com")) {
//                grantedAuthorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//                }
//
//                return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
//                }
//                }