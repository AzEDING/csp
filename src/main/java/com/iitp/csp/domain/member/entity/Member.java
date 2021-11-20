package com.iitp.csp.domain.member.entity;

import com.iitp.csp.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor @Builder
@Table(name = "member")

public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    // name
    @Column (name = "id_name")
    private String idName;

    // paswword
    @Column(name= "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "birth")
    private String birth;

    @Column(name = "phone", columnDefinition = "VARCHAR(32) comment '핸드폰번호'")
    private String phone;

    @Column(name = "nickName", length = 32)
    private String nickName;

    @Column(name = "contract")
    private Boolean contract;


    public void setData( String email,String birth, String phone, String nickName){
        this.email  = email;
        this.birth = birth;
        this.phone = phone;
        this.nickName = nickName;

    }
    public void setLogin( String idName, String password) {
        this.idName = idName;
        this.password = password;
    }


}
