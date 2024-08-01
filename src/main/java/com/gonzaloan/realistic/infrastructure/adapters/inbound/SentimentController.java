package com.gonzaloan.realistic.infrastructure.adapters.inbound;

import com.gonzaloan.realistic.application.usecases.AnalyzeImageUseCase;
import com.gonzaloan.realistic.domain.entities.ImageAnalysisResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/rekognition")
public class SentimentController {

    private final AnalyzeImageUseCase analyzeImageUseCase;
    @Value("${aws.rekognition.bucketName}")
    private String rekognitionBucketName;

    public SentimentController(AnalyzeImageUseCase analyzeImageUseCase) {
        this.analyzeImageUseCase = analyzeImageUseCase;
    }


    @GetMapping("/analyze-image")
    public ImageAnalysisResult analyzeImage(@RequestParam String key) throws IOException {
        return analyzeImageUseCase.execute(rekognitionBucketName, key);
    }
}
