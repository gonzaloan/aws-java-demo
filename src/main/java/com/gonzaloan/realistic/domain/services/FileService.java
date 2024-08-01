package com.gonzaloan.realistic.domain.services;

import com.gonzaloan.realistic.domain.entities.S3File;

import java.io.IOException;

public interface FileService {
    void uploadFile(S3File file);
    byte[] downloadFile(String bucketName, String key) throws IOException;
}
