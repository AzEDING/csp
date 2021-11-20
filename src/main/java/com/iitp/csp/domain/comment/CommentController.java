package com.iitp.csp.domain.comment;

import com.iitp.csp.domain.comment.entity.dto.CommentPageResDto;
import com.iitp.csp.domain.comment.entity.dto.CommentPutReqDto;
import com.iitp.csp.domain.comment.entity.dto.CommentReqDto;
import com.iitp.csp.domain.comment.entity.dto.CommentResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/notice/{id}/comment")
    @ApiOperation(value = "댓글 작성")
    public Long postComment(@RequestBody CommentReqDto dto) {
        return commentService.postComment(dto);
    }

    @GetMapping(value = "/notice/{id}/comment/{id}")
    @ApiOperation(value = "댓글 조회")
    public CommentResDto getComment(@RequestParam Long id)
    {
        return commentService.getComment(id);
    }

    @PutMapping(value = "/notice/{id}/comment/{comId}")
    @ApiOperation(value = "댓글 수정")
    public Long putComment(@RequestParam Long comId, @RequestBody CommentPutReqDto dto) {
        return commentService.putComment(comId,dto);
    }
    @DeleteMapping(value = "/notice/{id}/comment/{comId}")
    @ApiOperation(value = "댓글 삭제")
    public void deleteComment(@RequestParam Long comId) {
        commentService.deleteComment(comId);
    }

    @GetMapping(value = "/notice/{id}/comment")
    @ApiOperation(value = "댓글 창")
    public CommentPageResDto getCommentPage(@PageableDefault(size=5, page = 0, sort = "createdDate", direction = Sort.Direction.DESC) Pageable page) {
        return new CommentPageResDto(commentService.getCommentPage(page));
    }
}
