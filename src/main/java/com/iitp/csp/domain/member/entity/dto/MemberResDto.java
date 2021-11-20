package com.iitp.csp.domain.member.entity.dto;

import com.iitp.csp.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class MemberResDto {
    private String idName;
    private String email;
    private String birth;
    private String phone;
    private String nickName;

    public MemberResDto(Member entity) {
        this.idName = entity.getIdName();
        this.email = entity.getEmail();
        this.birth = entity.getBirth();
        this.phone = entity.getPhone();
        this.nickName = entity.getNickName();
    }
}
