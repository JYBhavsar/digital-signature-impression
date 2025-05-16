package com.sign.dto;

public class VerifyRequest {
    private String algorithm; // "RSA" or "ECC"
    private byte[] document;  // Raw document bytes
    private String signature; // Base64 encoded signature

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
