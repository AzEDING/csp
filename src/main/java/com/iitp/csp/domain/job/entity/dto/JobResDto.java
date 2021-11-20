package com.iitp.csp.domain.job.entity.dto;

import com.iitp.csp.domain.job.entity.Job;
import com.iitp.csp.domain.member.entity.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class JobResDto {
    private String title;
    private String content;
    private MemberResDto member;
    private LocalDateTime createDate;

    public JobResDto(Job entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreatedDate();
        if(entity.getMember() != null) {
            this.member = new MemberResDto(entity.getMember());
        }
    }
}
