package com.iitp.csp.domain.notice;

import com.iitp.csp.domain.notice.entity.dto.NoticePageResDto;
import com.iitp.csp.domain.notice.entity.dto.NoticePutReqDto;
import com.iitp.csp.domain.notice.entity.dto.NoticeReqDto;
import com.iitp.csp.domain.notice.entity.dto.NoticeResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping(value = "/notice")
    @ApiOperation(value = "공지 등록")
    public Long postNotice(@RequestBody NoticeReqDto dto){
        return noticeService.postNotice(dto);
    }

    @GetMapping(value = "/notice/{id}")
    @ApiOperation(value = "공지 조회")
    public NoticeResDto getNotice(@RequestParam Long id)
    {
        return noticeService.getNotice(id);
    }

    @PutMapping(value = "/notice/{id}")
    @ApiOperation(value = "공지 수정")
    public Long putNotice(@RequestParam Long id, @RequestBody NoticePutReqDto dto) {
        return noticeService.putNotice(id, dto);
    }

    @DeleteMapping(value = "/notice/{id}")
    @ApiOperation(value = "공지 삭제")
    public void deleteNotice(@RequestParam Long id) {
        noticeService.deleteNotice(id);
    }

    // https://www.csp.com/notice?page=1&size=10&createDate,DESC

    @GetMapping(value = "/notice")
    @ApiOperation(value = "공지 전체 조회")
    public NoticePageResDto getNoticePage(@PageableDefault(size=20, page = 0, sort = "createdDate", direction = Sort.Direction.DESC) Pageable page) {
        return new NoticePageResDto(noticeService.getNoticePage(page));
    }
}
