package com.iitp.csp.domain.job;

import com.iitp.csp.domain.job.entity.dto.JobPageResDto;
import com.iitp.csp.domain.job.entity.dto.JobPutReqDto;
import com.iitp.csp.domain.job.entity.dto.JobReqDto;
import com.iitp.csp.domain.job.entity.dto.JobResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/job")
    @ApiOperation(value = "구인구직 게시물 등록")
    public Long postJob(@RequestBody JobReqDto dto) { return jobService.postJob(dto); }
    @GetMapping(value = "/job/{id}")
    @ApiOperation(value = "구인구직 게시물 조회")
    public JobResDto getJob(@PathVariable Long id) { return jobService.getJob(id); }
    @PutMapping(value = "/job/{id}")
    @ApiOperation(value = "구인구직 게시물 수정")
    public Long putJob(@PathVariable Long id, @RequestBody JobPutReqDto dto) {
        return jobService.putJob(id,dto);
    }
    @DeleteMapping(value = "/job/{id}")
    @ApiOperation(value = "구인구직 게시물 삭제")
    public void deleteJob(@PathVariable Long id) { jobService.deleteJob(id); }
    @GetMapping(value = "/job")
    @ApiOperation(value = "구인구직 게시물 전체 조회")
    public JobPageResDto getJobPage(@PageableDefault(size = 20,page = 0,sort = "createdDate",direction = Sort.Direction.DESC) Pageable page) {
        return new JobPageResDto(jobService.getJobPage(page));
    }
}
