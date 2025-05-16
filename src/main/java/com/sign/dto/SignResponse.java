package com.sign.dto;

public class SignResponse {
    private String signature; // Base64 encoded signature
    private String publicKey; // Base64 encoded public key

    // Getters and Setters
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
