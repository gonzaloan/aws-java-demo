package com.gonzaloan.realistic.infrastructure.adapters.outbound;

import com.gonzaloan.realistic.domain.entities.ImageAnalysisResult;
import com.gonzaloan.realistic.domain.services.ImageAnalysisService;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;

@Service
public class RekognitionAdapter implements ImageAnalysisService {
    private final RekognitionClient rekognitionClient;

    public RekognitionAdapter(RekognitionClient rekognitionClient) {
        this.rekognitionClient = rekognitionClient;
    }


    @Override
    public ImageAnalysisResult analyzeImage(String bucketName, String key) {
        DetectLabelsRequest request = DetectLabelsRequest.builder()
                .image(Image.builder()
                        .s3Object(S3Object.builder()
                                .bucket(bucketName)
                                .name(key)
                                .build())
                        .build())
                .build();

        DetectLabelsResponse response = rekognitionClient.detectLabels(request);

        return new ImageAnalysisResult(key, response.labels().stream()
                .map(Label::name)
                .toList());
    }
}
