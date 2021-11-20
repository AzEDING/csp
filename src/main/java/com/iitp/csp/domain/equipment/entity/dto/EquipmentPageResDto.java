package com.iitp.csp.domain.equipment.entity.dto;

import com.iitp.csp.domain.equipment.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class EquipmentPageResDto {
    private Integer numberOfElements;
    private Long totalElements;
    private Boolean last;
    private Integer totalPage;
    private List<EquipmentResDto> list = new ArrayList<>();

    public EquipmentPageResDto(Page<Equipment> page) {
        this.numberOfElements = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();

        for(Equipment equipment: page){
            this.list.add(new EquipmentResDto(equipment));
        }
    }

}
