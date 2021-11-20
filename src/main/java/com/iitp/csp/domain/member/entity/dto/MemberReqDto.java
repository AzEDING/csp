package com.iitp.csp.domain.member.entity.dto;

import com.iitp.csp.domain.member.entity.Member;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class MemberReqDto {

    @ApiModelProperty(required = true, value = "이름", example = "홍길동")
    private String idName;
    @ApiModelProperty(required = true, value = "비밀번호", example = "password")
    private String password;
    @ApiModelProperty(required = true, value = "이메일", example = "test@test.com")
    private String email;
    @ApiModelProperty(required = true, value = "생일 ", example = "19901010")
    private String birth;
    @ApiModelProperty(required = true, value = "휴대폰", example = "01011111111")
    private String phone;
    @ApiModelProperty(required = true, value = "별명", example = "길동")
    private String nickName;
    @ApiModelProperty(required = true, value = "약관동의", example = "true")
    private Boolean contract;

    public Member toEntity() {
        return Member.builder()
                .idName(idName)
                .email(email)
                .birth(birth)
                .nickName(nickName)
                .password(password)
                .phone(phone)
                .contract(contract)
                .build();
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void getContract(Boolean contract) { this.contract = contract; }
}
