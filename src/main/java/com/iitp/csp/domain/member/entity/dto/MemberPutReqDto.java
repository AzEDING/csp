package com.iitp.csp.domain.member.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class MemberPutReqDto {
    @ApiModelProperty(required = true, value = "생일", example = "19901111")
    private String birth;
    @ApiModelProperty(required = true, value = "이메일", example = "test1@test.net")
    private String email;
    @ApiModelProperty(required = true, value = "핸드폰", example = "01011112222")
    private String phone;
    @ApiModelProperty(required = true, value = "별명", example = "길동1")
    private String nickName;
}
