package com.iitp.csp.domain.member.entity.dto;

import com.iitp.csp.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor

public class MemberPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<MemberResDto> list = new ArrayList<>();

    public MemberPageResDto(Page<Member> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Member member: page){
            this.list.add(new MemberResDto(member));
        }

    }
}
