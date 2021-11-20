package com.iitp.csp.domain.community.entity.dto;

import com.iitp.csp.domain.community.entity.Community;
import com.iitp.csp.domain.member.entity.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommunityResDto {
    private String title;
    private String content;
    private MemberResDto member;
    private LocalDateTime createDate;

    public CommunityResDto(Community entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreatedDate();
        if (entity.getMember() != null) {
            this.member = new MemberResDto(entity.getMember());
        }
    }
}
