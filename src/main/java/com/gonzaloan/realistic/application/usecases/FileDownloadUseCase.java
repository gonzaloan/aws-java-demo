package com.gonzaloan.realistic.application.usecases;

import com.gonzaloan.realistic.domain.services.FileService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileDownloadUseCase {

    private final FileService fileService;

    public FileDownloadUseCase(FileService fileService) {
        this.fileService = fileService;
    }

    public byte[] execute(String bucketName, String key) throws IOException {
        return fileService.downloadFile(bucketName, key);
    }

}
