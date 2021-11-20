package com.iitp.csp.domain.cspfile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class CspFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fileSize")
    private String fileSize;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "filePath")
    private String filePath;

    @Builder
    public void setCspFile(Long fileId, String fileName, String fileSize, String fileType) {
        this.id = fileId;
        this.name = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }
}
