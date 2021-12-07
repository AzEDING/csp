package com.iitp.csp.domain.illust;

import com.iitp.csp.domain.illust.entity.dto.IllustPageResDto;
import com.iitp.csp.domain.illust.entity.dto.IllustPutReqDto;
import com.iitp.csp.domain.illust.entity.dto.IllustReqDto;
import com.iitp.csp.domain.illust.entity.dto.IllustResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class IllustController {
    @Autowired
    private IllustService illustService;

    @PostMapping(value = "/illust")
    @ApiOperation(value = "일러 등록")
    public Long postIllust(@RequestBody IllustReqDto dto) {
        return illustService.postIllust(dto);
    }

    @GetMapping(value = "/illust/{id}")
    @ApiOperation(value = "일러 조회")
    public IllustResDto getIllust(@PathVariable Long id) {
        return illustService.getIllust(id);
    }

    @PutMapping(value = "/illust/{id}")
    @ApiOperation(value = "일러 수정")
    public Long putIllust(@PathVariable Long id, @RequestBody IllustPutReqDto dto) {
        return illustService.putIllust(id, dto);
    }

    @DeleteMapping(value = "/illust/{id}")
    @ApiOperation(value = "일러 삭제")
    public void deleteIllust(@PathVariable Long id) {
        illustService.deleteIllust(id);
    }

    @GetMapping(value = "/illust")
    @ApiOperation(value = "일러 전체 조회")
    public IllustPageResDto getIllustPage(@PageableDefault(size=20, page = 0, sort = "createdDate", direction = Sort.Direction.DESC) Pageable page) {
        return new IllustPageResDto(illustService.getIllustPage(page));
    }
}
