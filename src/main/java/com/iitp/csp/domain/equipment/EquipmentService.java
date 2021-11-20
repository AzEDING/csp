package com.iitp.csp.domain.equipment;

import com.iitp.csp.domain.equipment.entity.Equipment;
import com.iitp.csp.domain.equipment.entity.EquipmentRepository;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentPutReqDto;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentReqDto;
import com.iitp.csp.domain.equipment.entity.dto.EquipmentResDto;
import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long postEquipment(EquipmentReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Equipment equipment = dto.toEntity();
        equipment.setMember(member);
        return equipmentRepository.save(equipment).getEquipmentId();
    }

    @Transactional(readOnly = true)
    public EquipmentResDto getEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(()-> new RuntimeException("해당게시물없음"));
        return new EquipmentResDto(equipment);
    }

    @Transactional
    public Long putEquipment(Long id, EquipmentPutReqDto dto) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(()-> new RuntimeException("해당게시물 없음"));

        equipment.setEquipment(dto.getTitle(),dto.getContent());
        Equipment result = equipmentRepository.save(equipment);
        return result.getEquipmentId();
    }

    public void deleteEquipment(Long id) { equipmentRepository.deleteById(id); }

    @Transactional(readOnly = true)
    public Page<Equipment> getEquipmentPage(Pageable page) { return equipmentRepository.findAll(page); }
}
