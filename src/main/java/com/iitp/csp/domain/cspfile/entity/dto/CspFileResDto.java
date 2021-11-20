package com.iitp.csp.domain.cspfile.entity.dto;

import com.iitp.csp.domain.cspfile.entity.CspFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CspFileResDto {
    private Long Id;
    private String fileName;
    private String fileSize;
    private String filePath;

    public CspFileResDto(CspFile entity) {
        this.Id = entity.getId();
        this.fileName = entity.getName();
        this.filePath = entity.getFilePath();
        this.fileSize = entity.getFileSize();
    }
}
