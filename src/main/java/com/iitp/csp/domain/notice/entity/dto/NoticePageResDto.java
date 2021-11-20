package com.iitp.csp.domain.notice.entity.dto;

import com.iitp.csp.domain.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class NoticePageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<NoticeResDto> list = new ArrayList<>();

    public NoticePageResDto(Page<Notice> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Notice notice: page){
            this.list.add(new NoticeResDto(notice));
        }
    }
}
