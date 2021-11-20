package com.iitp.csp.domain.member.entity.dto;

import com.iitp.csp.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberLoginResDto {
    private Long memberId;
    private String idName;


    public MemberLoginResDto(Member entity){
        this.memberId = entity.getMemberId();
        this.idName = entity.getIdName();

    }
}
