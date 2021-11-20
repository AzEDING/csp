package com.iitp.csp.domain.cspfile;

import com.iitp.csp.domain.cspfile.entity.CspFile;
import com.iitp.csp.domain.cspfile.entity.CspFileRepository;
import com.iitp.csp.domain.cspfile.entity.dto.CspFileReqDto;
import com.iitp.csp.domain.cspfile.entity.dto.CspFileResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CspFileService {
    @Autowired
    private CspFileRepository cspFileRepository;

    public Long postCspFile(CspFileReqDto dto) {
        CspFile cspFile = new CspFile();
        cspFile.setCspFile(dto.getFileId(), dto.getFileName(),dto.getFileSize(),dto.getFileType());

        CspFile result = cspFileRepository.save(cspFile);

        return result.getId();
    }

    public CspFileResDto getCspFile(Long id) {
        CspFile cspFile = cspFileRepository.findById(id).orElseThrow(()->new RuntimeException("해당 파일이 없습니다"));
        return new CspFileResDto(cspFile);
    }

    public void deleteCspFile(Long id) {
        cspFileRepository.deleteById(id);
    }
}
