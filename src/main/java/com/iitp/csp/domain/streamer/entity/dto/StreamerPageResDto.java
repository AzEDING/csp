package com.iitp.csp.domain.streamer.entity.dto;


import com.iitp.csp.domain.streamer.entity.Streamer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class StreamerPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<StreamerResDto> list = new ArrayList<>();

    public StreamerPageResDto(Page<Streamer> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Streamer streamer: page){
            this.list.add(new StreamerResDto(streamer));
        }
    }
}
