package com.gonzaloan.realistic.domain.entities;

public class S3File {

    private String bucketName;
    private String key;
    private byte[] content;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public S3File() {
    }

    public S3File(String bucketName, String key, byte[] content) {
        this.bucketName = bucketName;
        this.key = key;
        this.content = content;
    }
}
