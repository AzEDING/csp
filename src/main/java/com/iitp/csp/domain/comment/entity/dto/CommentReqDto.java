package com.iitp.csp.domain.comment.entity.dto;

import com.iitp.csp.domain.comment.entity.Comment;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentReqDto {
    @ApiModelProperty(required = true, value = "댓글", example = "댓글1")
    private String content;
    @ApiModelProperty(required = true, value = "작성자", example = "1")
    private Long memberId;
    @ApiModelProperty(required = true, value = "게시글", example = "1")
    private Long noticeId;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .build();
    }
}
