package com.iitp.csp.domain.comment;

import com.iitp.csp.domain.comment.entity.Comment;
import com.iitp.csp.domain.comment.entity.CommentRepository;
import com.iitp.csp.domain.comment.entity.dto.CommentPutReqDto;
import com.iitp.csp.domain.comment.entity.dto.CommentReqDto;
import com.iitp.csp.domain.comment.entity.dto.CommentResDto;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import com.iitp.csp.domain.notice.entity.Notice;
import com.iitp.csp.domain.notice.entity.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Long postComment(CommentReqDto dto) {
        Notice notice = noticeRepository.findById(dto.getNoticeId()).orElseThrow(()-> new RuntimeException());
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Comment comment = dto.toEntity();
        comment.setNotice(notice);
        comment.setMember(member);
        return commentRepository.save(comment).getCommentId();
    }
    @Transactional(readOnly = true)
    public CommentResDto getComment(Long id){
        Comment comment = commentRepository.findById(id).orElseThrow(()-> new RuntimeException("댓글 없음"));
        return new CommentResDto(comment);
    }
    @Transactional
    public Long putComment(Long comId, CommentPutReqDto dto) {
        Notice notice = noticeRepository.findById(dto.getNoticeId()).orElseThrow(()-> new RuntimeException("해당 게시물 없음"));
        Comment comment = commentRepository.findById(comId).orElseThrow(()->new RuntimeException("댓글 없음"));

        comment.setComment(dto.getContent());
        comment.setNotice(notice);
        Comment result = commentRepository.save(comment);
        return result.getCommentId();
    }

    public void deleteComment(Long comId) {
        commentRepository.deleteById(comId);
    }
    @Transactional(readOnly = true)
    public Page<Comment> getCommentPage(Pageable page){
        return commentRepository.findAll(page);
    }
}
