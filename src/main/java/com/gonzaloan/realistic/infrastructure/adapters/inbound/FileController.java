package com.gonzaloan.realistic.infrastructure.adapters.inbound;


import com.gonzaloan.realistic.application.usecases.*;
import com.gonzaloan.realistic.domain.entities.S3File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {


    private final FileUploadUseCase fileUploadUseCase;
    private final FileDownloadUseCase fileDownloadUseCase;

    public FileController(FileUploadUseCase fileUploadUseCase, FileDownloadUseCase fileDownloadUseCase) {
        this.fileUploadUseCase = fileUploadUseCase;
        this.fileDownloadUseCase = fileDownloadUseCase;
    }

    @Value("${aws.bucketName}")
    private String bucketName;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void uploadFile(@RequestParam String key, @RequestParam MultipartFile content) throws IOException {
        fileUploadUseCase.execute(new S3File(bucketName, key, content.getBytes()));
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String key) throws IOException {
        byte[] data = fileDownloadUseCase.execute(bucketName, key);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        httpHeaders.setContentLength(data.length);
        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }


}
