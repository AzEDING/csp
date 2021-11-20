package com.iitp.csp.domain.comment.entity.dto;

import com.iitp.csp.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CommentPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<CommentResDto> list = new ArrayList<>();

    public CommentPageResDto(Page<Comment> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Comment comment: page){
            this.list.add(new CommentResDto(comment));
        }
    }
}
