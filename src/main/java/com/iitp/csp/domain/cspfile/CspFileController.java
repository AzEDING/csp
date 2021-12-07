package com.iitp.csp.domain.cspfile;

import com.iitp.csp.domain.cspfile.entity.dto.CspFileReqDto;
import com.iitp.csp.domain.cspfile.entity.dto.CspFileResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CspFileController {
    @Autowired
    private CspFileService cspFileService;

    @PostMapping(value = "/file")
    @ApiOperation(value = "파일 첨부")
    public Long postCspFile(@RequestBody CspFileReqDto dto){
        return cspFileService.postCspFile(dto);
    }

    @GetMapping(value = "/file/{id}")
    @ApiOperation(value = "파일 다운")
    public CspFileResDto getCspFile(@PathVariable Long id){
        return cspFileService.getCspFile(id);
    }


    @DeleteMapping(value = "/file/{id}")
    @ApiOperation(value = "첨부 삭제")
    public void deleteCspFile(@PathVariable Long id) {
        cspFileService.deleteCspFile(id);
    }
}
