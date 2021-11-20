package com.iitp.csp.domain.illust.entity.dto;

import com.iitp.csp.domain.illust.entity.Illust;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class IllustPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<IllustResDto> list = new ArrayList<>();

    public IllustPageResDto(Page<Illust> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Illust illust: page){
            this.list.add(new IllustResDto(illust));
        }
    }

}
