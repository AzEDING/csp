package com.iitp.csp.domain.community.entity.dto;

import com.iitp.csp.domain.community.entity.Community;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CommunityPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<CommunityResDto> list = new ArrayList<>();

    public CommunityPageResDto(Page<Community> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Community community: page){
            this.list.add(new CommunityResDto(community));
        }
    }
}
