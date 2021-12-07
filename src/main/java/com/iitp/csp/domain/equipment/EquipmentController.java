package com.iitp.csp.domain.equipment;

import com.iitp.csp.domain.equipment.entity.dto.EquipmentPageResDto;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentPutReqDto;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentReqDto;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentResDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(value = "/equipment")
    @ApiOperation(value = "장비 게시물 등록")
    public Long postEquipment(@RequestBody EquipmentReqDto dto) { return equipmentService.postEquipment(dto); }

    @GetMapping(value = "/equipment/{id}")
    @ApiOperation(value = "장비 게시물 조회")
    public EquipmentResDto getEquipment(@PathVariable Long id) { return equipmentService.getEquipment(id); }

    @PutMapping(value = "/equipment/{id}")
    public Long putEquipment(@PathVariable Long id, @RequestBody EquipmentPutReqDto dto) {
        return equipmentService.putEquipment(id,dto);
    }

    @DeleteMapping(value = "/equipment/{id}")
    @ApiOperation(value = "장비 게시물 수정")
    public void deleteEquipment(@PathVariable Long id) { equipmentService.deleteEquipment(id); }

    @GetMapping(value = "/equipment")
    @ApiOperation(value = "장비 게시물 전체 조회")
    public EquipmentPageResDto getEquipmentPage(@PageableDefault(size=20, page = 0, sort = "createdDate", direction = Sort.Direction.DESC) Pageable page) {
        return new EquipmentPageResDto(equipmentService.getEquipmentPage(page));
    }
}
