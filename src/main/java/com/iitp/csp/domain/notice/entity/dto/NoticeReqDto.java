package com.iitp.csp.domain.notice.entity.dto;

import com.iitp.csp.domain.notice.entity.Notice;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NoticeReqDto {
    @ApiModelProperty(required = true, value = "제목", example = "제목1")
    private String title;
    @ApiModelProperty(required = true, value = "내용", example = "내용1")
    private String content;
//    private Long fileId;
    @ApiModelProperty(required = true, value = "작성자", example = "1")
    private Long memberId;

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .build();
    }
}
