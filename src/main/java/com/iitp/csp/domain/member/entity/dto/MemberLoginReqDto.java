package com.iitp.csp.domain.member.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberLoginReqDto {
    @ApiModelProperty(required = true, value = "이름", example = "홍길동")
    private String idName;
    @ApiModelProperty(required = true, value = "비밀번호", example = "password")
    private String password;

}
