package com.iitp.csp.domain.comment.entity;

import com.iitp.csp.domain.BaseTimeEntity;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.notice.entity.Notice;
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
@Table(name = "comment")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setComment(String content){
        this.content = content;
    }
    public void setNotice(Notice notice){
        this.notice = notice;
    }
    public void setMember(Member member) {
        this.member = member;
    }
}
