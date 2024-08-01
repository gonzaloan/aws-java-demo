package com.gonzaloan.realistic.infrastructure.adapters.outbound;

import com.gonzaloan.realistic.domain.entities.S3File;
import com.gonzaloan.realistic.domain.services.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;


@Service
public class S3Adapter implements FileService {

    private final S3Client s3Client;

    public S3Adapter(S3Client s3Client) {
        this.s3Client = s3Client;
    }


    @Override
    public void uploadFile(S3File file) {
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(file.getBucketName())
                        .key(file.getKey())
                        .build(),
                RequestBody.fromBytes(file.getContent())
        );
    }

    @Override
    public byte[] downloadFile(String bucketName, String key) throws IOException {

        ResponseInputStream<GetObjectResponse> object = s3Client.getObject(
                GetObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build());

        try{
            return IOUtils.toByteArray(object);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
