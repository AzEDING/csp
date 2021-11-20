package com.iitp.csp.domain.community;

import com.iitp.csp.domain.community.entity.dto.CommunityPageResDto;
import com.iitp.csp.domain.community.entity.dto.CommunityPutReqDto;
import com.iitp.csp.domain.community.entity.dto.CommunityReqDto;
import com.iitp.csp.domain.community.entity.dto.CommunityResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @PostMapping(value = "/community")
    @ApiOperation(value = "/커뮤니티 등록")
    public Long postCommunity(@RequestBody CommunityReqDto dto) {
        return communityService.postCommunity(dto);
    }

    @GetMapping(value = "/community/{id}")
    @ApiOperation(value = "커뮤니티 조회")
    public CommunityResDto getCommunity(@RequestParam Long id) { return communityService.getCommunity(id); }

    @PutMapping(value = "/community/{id}")
    @ApiOperation(value = "커뮤니티 수정")
    public Long putCommunity(@RequestParam Long id, @RequestBody CommunityPutReqDto dto) {
        return communityService.putCommunity(id,dto);
    }

    @DeleteMapping(value = "/community/{id}")
    @ApiOperation(value = "커뮤니티 삭제")
    public void deleteCommunity(@RequestParam Long id) {
        communityService.deleteCommunity(id);
    }

    @GetMapping(value = "/community")
    @ApiOperation(value = "커뮤니티 전체 조회")
    public CommunityPageResDto getCommunityPage(@PageableDefault(size=20, page = 0, sort = "createdDate",direction = Sort.Direction.DESC)Pageable page) {
        return new CommunityPageResDto(communityService.getCommunityPage(page));
    }
}
