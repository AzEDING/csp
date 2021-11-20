package com.iitp.csp.domain.community.entity;


import com.iitp.csp.domain.BaseTimeEntity;
import com.iitp.csp.domain.cspfile.entity.CspFile;
import com.iitp.csp.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "community")
public class Community extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private  Long communityId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "file_id")
    private CspFile cspFile;

    public void setCommunity(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void setMember(Member member)
    {
        this.member = member;
    }
}
