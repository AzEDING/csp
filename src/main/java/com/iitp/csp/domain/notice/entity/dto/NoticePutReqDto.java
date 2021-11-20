package com.iitp.csp.domain.notice.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NoticePutReqDto {
    @ApiModelProperty(required = true, value = "제목", example = "제목2")
    private String title;
    @ApiModelProperty(required = true, value = "내용", example = "내용2")
    private String content;
//    private Long fileId;
}