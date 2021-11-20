package com.iitp.csp.domain.notice;

import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import com.iitp.csp.domain.notice.entity.Notice;
import com.iitp.csp.domain.notice.entity.NoticeRepository;
import com.iitp.csp.domain.notice.entity.dto.NoticePutReqDto;
import com.iitp.csp.domain.notice.entity.dto.NoticeReqDto;
import com.iitp.csp.domain.notice.entity.dto.NoticeResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long postNotice(NoticeReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Notice notice = dto.toEntity();
        notice.setMember(member);
        return noticeRepository.save(notice).getNoticeId();
    }

    @Transactional(readOnly = true)
    public NoticeResDto getNotice(Long id){
        Notice notice = noticeRepository.findById(id).orElseThrow(()->new RuntimeException("해당게시물없음"));
        return new NoticeResDto(notice);
    }

    @Transactional
    public Long putNotice(Long id, NoticePutReqDto dto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(()->new RuntimeException("수정게시물없음"));

        notice.setNotice(dto.getTitle(), dto.getContent());
        Notice result = noticeRepository.save(notice);
        return result.getNoticeId();
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Notice> getNoticePage(Pageable page){
        return noticeRepository.findAll(page);
    }
}
