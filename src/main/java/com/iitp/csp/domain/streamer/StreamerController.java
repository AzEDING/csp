package com.iitp.csp.domain.streamer;

import com.iitp.csp.domain.streamer.entity.dto.StreamerPageResDto;
import com.iitp.csp.domain.streamer.entity.dto.StreamerPutReqDto;
import com.iitp.csp.domain.streamer.entity.dto.StreamerReqDto;
import com.iitp.csp.domain.streamer.entity.dto.StreamerResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class StreamerController {
    @Autowired
    private StreamerService streamerService;

    @PostMapping(value = "/streamer")
    @ApiOperation(value = "스트리머 게시물 등록")
    public Long postStreamer(@RequestBody StreamerReqDto dto) { return streamerService.postStreamer(dto); }

    @GetMapping(value = "/streamer/{id}")
    @ApiOperation(value = "스트리머 게시물 조회")
    public StreamerResDto getStreamer(@RequestParam Long id) {
        return streamerService.getStreamer(id);
    }

    @PutMapping(value = "/streamer/{id}")
    @ApiOperation(value = "스트리머 게시물 수정")
    public Long putStreamer(@RequestParam Long id, @RequestBody StreamerPutReqDto dto) {
        return streamerService.putStreamer(id, dto);
    }

    @DeleteMapping(value = "/streamer/{id}")
    @ApiOperation(value = "스트리머 게시물 삭제")
    public void deleteStreamer(@RequestParam Long id){
        streamerService.deleteStreamer(id);
    }

    @GetMapping(value = "/streamer")
    @ApiOperation(value = "스트리머 게시물 전체 조회")
    public StreamerPageResDto getStreamerPage(@PageableDefault(size=20, page = 0, sort = "createdDate", direction =Sort.Direction.DESC) Pageable page) {
        return new StreamerPageResDto(streamerService.getStreamerPage(page));
    }
}
