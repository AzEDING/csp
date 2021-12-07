package com.iitp.csp.domain.comment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentPutReqDto {
    @ApiModelProperty(required = true, value = "댓글", example = "댓글2")
    private String content;
}
