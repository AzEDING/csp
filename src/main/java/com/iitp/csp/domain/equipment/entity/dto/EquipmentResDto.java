package com.iitp.csp.domain.equipment.entity.dto;

import com.iitp.csp.domain.equipment.entity.Equipment;
import com.iitp.csp.domain.member.entity.dto.MemberResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class EquipmentResDto {
    private String title;
    private String content;
    private MemberResDto member;
    private LocalDateTime createDate;

    public EquipmentResDto(Equipment entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreatedDate();
        if(entity.getMember() != null) {
            this.member = new MemberResDto(entity.getMember());
        }
    }
}
