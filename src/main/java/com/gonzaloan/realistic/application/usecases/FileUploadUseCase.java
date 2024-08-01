package com.gonzaloan.realistic.application.usecases;

import com.gonzaloan.realistic.domain.entities.S3File;
import com.gonzaloan.realistic.domain.services.FileService;
import org.springframework.stereotype.Component;

@Component
public class FileUploadUseCase {
    private final FileService fileService;

    public FileUploadUseCase(FileService fileService) {
        this.fileService = fileService;
    }

    public void execute(S3File file){
        fileService.uploadFile(file);
    }
}
