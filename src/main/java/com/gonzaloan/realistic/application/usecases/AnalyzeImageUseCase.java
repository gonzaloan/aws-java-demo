package com.gonzaloan.realistic.application.usecases;

import com.gonzaloan.realistic.domain.entities.ImageAnalysisResult;
import com.gonzaloan.realistic.domain.services.ImageAnalysisService;
import org.springframework.stereotype.Component;

@Component
public class AnalyzeImageUseCase {

    private final ImageAnalysisService imageAnalysisService;

    public AnalyzeImageUseCase(ImageAnalysisService imageAnalysisService) {
        this.imageAnalysisService = imageAnalysisService;
    }

    public ImageAnalysisResult execute(String bucketName, String key) {
        return imageAnalysisService.analyzeImage(bucketName, key);
    }
}
