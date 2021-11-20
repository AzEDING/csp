package com.iitp.csp.domain.job.entity.dto;

import com.iitp.csp.domain.job.entity.Job;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class JobReqDto {
    @ApiModelProperty(required = true, value = "제목", example = "제목1")
    private String title;
    @ApiModelProperty(required = true, value = "내용", example = "내용1")
    private String content;
    @ApiModelProperty(required = true, value = "작성자", example = "1")
    private Long memberId;

    public Job toEntity() {
        return Job.builder()
                .title(title)
                .content(content)
                .build();
    }
}
