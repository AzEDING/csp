package com.iitp.csp.domain.job;

import com.iitp.csp.domain.job.entity.Job;
import com.iitp.csp.domain.job.entity.JobRepository;
import com.iitp.csp.domain.job.entity.dto.JobPutReqDto;
import com.iitp.csp.domain.job.entity.dto.JobReqDto;
import com.iitp.csp.domain.job.entity.dto.JobResDto;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Transactional
    public Long postJob(JobReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Job job = dto.toEntity();
        job.setMember(member);
        return jobRepository.save(job).getJobId();
    }
    @Transactional(readOnly = true)
    public JobResDto getJob(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("해당게시물없음"));
        return new JobResDto(job);
    }
    @Transactional
    public Long putJob(Long id, JobPutReqDto dto) {
        Job job = jobRepository.findById(id).orElseThrow(()->new RuntimeException("해당게시물없음"));

        job.setJob(dto.getTitle(),dto.getContent());
        Job result = jobRepository.save(job);
        return result.getJobId();
    }

    public void deleteJob(Long id) { jobRepository.deleteById(id); }

    @Transactional(readOnly = true)
    public Page<Job> getJobPage(Pageable page) { return jobRepository.findAll(page); }
}
