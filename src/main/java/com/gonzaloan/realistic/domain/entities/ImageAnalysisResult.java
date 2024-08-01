package com.gonzaloan.realistic.domain.entities;

import java.util.List;

public class ImageAnalysisResult {
    private String imageKey;
    private List<String> labels;

    public ImageAnalysisResult(String imageKey, List<String> labels) {
        this.imageKey = imageKey;
        this.labels = labels;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
