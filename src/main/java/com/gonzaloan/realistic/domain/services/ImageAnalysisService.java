package com.gonzaloan.realistic.domain.services;

import com.gonzaloan.realistic.domain.entities.ImageAnalysisResult;

public interface ImageAnalysisService {
    ImageAnalysisResult analyzeImage (String bucketName, String key);
}
