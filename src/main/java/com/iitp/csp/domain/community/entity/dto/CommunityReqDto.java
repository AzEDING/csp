package com.iitp.csp.domain.community.entity.dto;

import com.iitp.csp.domain.community.entity.Community;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommunityReqDto {
    @ApiModelProperty(required = true, value = "제목", example = "공지1")
    private String title;
    @ApiModelProperty(required = true, value = "내용", example = "내용1")
    private String content;
    @ApiModelProperty(required = true, value = "작성자", example = "1")
    private Long memberId;

    public Community toEntity() {
        return Community.builder()
                .title(title)
                .content(content)
                .build();
    }
}
