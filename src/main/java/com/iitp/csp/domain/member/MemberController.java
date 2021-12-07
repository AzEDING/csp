package com.iitp.csp.domain.member;


import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.dto.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/member/signup")
    @ApiOperation(value = "회원가입")
    public Long postMember(@RequestBody MemberReqDto dto) {
        return memberService.postMember(dto);
    }

    @GetMapping(value = "/member/{id}")
    @ApiOperation(value = "회원조회")
    public MemberResDto getMember(@PathVariable Long id) {
        return  memberService.getMember(id);
    }

    @PutMapping(value = "/member/{id}")
    @ApiOperation(value = "회원수정")
    public Long putMember(@PathVariable Long id, @RequestBody MemberPutReqDto dto) {
        return memberService.putMember(id, dto);
    }

    @DeleteMapping(value = "/member/{id}")
    @ApiOperation(value = "회원탈퇴")
    public void deleteMember(@PathVariable Long id) { memberService.deleteMember(id);}

    @GetMapping(value = "/member")
    @ApiOperation(value = "전체회원조회")
    public MemberPageResDto getMemberPage(@PageableDefault(size = 20, page = 0, sort = "createDate",direction = Sort.Direction.DESC) Pageable page) {
        return new MemberPageResDto(memberService.getMemberPage(page));
    }

    @PostMapping(value = "/member/login")
    @ApiOperation(value = "로그인")
    public Member loginMember(@RequestBody MemberLoginReqDto dto) {
        return memberService.loginMember(dto);
        }

        //fixme create request dto

}

