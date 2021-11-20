package com.iitp.csp.domain.comment.entity.dto;

import com.iitp.csp.domain.comment.entity.Comment;
import com.iitp.csp.domain.member.entity.dto.MemberResDto;
import com.iitp.csp.domain.notice.entity.dto.NoticeResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommentResDto {
    private String content;
    private MemberResDto member;
    private NoticeResDto notice;
    private LocalDateTime createDate;

    public CommentResDto(Comment entity) {
        this.content = entity.getContent();
        this.createDate = entity.getCreatedDate();
        if(entity.getMember()!=null){
            this.member = new MemberResDto(entity.getMember());
        }
        if(entity.getNotice()!=null){
            this.notice = new NoticeResDto(entity.getNotice());
        }
    }
}
