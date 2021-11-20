package com.iitp.csp.domain.cspfile.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class CspFileReqDto {
    private Long fileId;
    private String fileName;
    private String fileSize;
    private String filePath;
    private String fileType;
}
