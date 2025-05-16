package com.sign.dto;

public class SignRequest {
    private String algorithm; // "RSA" or "ECC"
    private byte[] document;  // Raw document bytes (base64 encoded in JSON)

    // Getters and Setters
    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }
}
