package com.iitp.csp.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="file")
public class CspFileProperties {
    private String filePath;

    public String getUploadDir() {
        return filePath;
    }

    public void setUploadDir(String uploadDir) {
        this.filePath = filePath;
    }
}
