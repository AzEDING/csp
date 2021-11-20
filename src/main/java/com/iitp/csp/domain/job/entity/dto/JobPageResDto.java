package com.iitp.csp.domain.job.entity.dto;

import com.iitp.csp.domain.job.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class JobPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<JobResDto> list = new ArrayList<>();

    public JobPageResDto(Page<Job> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Job job: page) {
            this.list.add(new JobResDto(job));
        }
    }
}
