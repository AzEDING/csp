package com.iitp.csp.domain.comment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentPutReqDto {
    @ApiModelProperty(required = true, value = "댓글", example = "댓글2")
    private String content;
    @ApiModelProperty(required = true, value = "게시글", example = "1")
    private Long noticeId;
}
