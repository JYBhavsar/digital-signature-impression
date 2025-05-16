package com.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sign.service.SignatureService;

@RestController
@RequestMapping("/api/signature")
public class SignatureController {

    @Autowired
    private SignatureService signatureService;

    @PostMapping("/generate/rsa")
    public ResponseEntity<String> generateRSASignature(@RequestBody byte[] data) {
        try {
            String signature = signatureService.generateRSASignature(data);
            return ResponseEntity.ok(signature);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating RSA signature: " + e.getMessage());
        }
    }

    @PostMapping("/verify/rsa")
    public ResponseEntity<String> verifyRSASignature(@RequestBody byte[] data, @RequestParam String signature) {
        try {
            boolean isValid = signatureService.verifyRSASignature(data, signature);
            return ResponseEntity.ok("RSA Signature Valid: " + isValid);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error verifying RSA signature: " + e.getMessage());
        }
    }

    @PostMapping("/generate/ecc")
    public ResponseEntity<String> generateECCSignature(@RequestBody byte[] data) {
        try {
            String signature = signatureService.generateECCSignature(data);
            return ResponseEntity.ok(signature);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating ECC signature: " + e.getMessage());
        }
    }

    @PostMapping("/verify/ecc")
    public ResponseEntity<String> verifyECCSignature(@RequestBody byte[] data, @RequestParam String signature) {
        try {
            boolean isValid = signatureService.verifyECCSignature(data, signature);
            return ResponseEntity.ok("ECC Signature Valid: " + isValid);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error verifying ECC signature: " + e.getMessage());
        }
    }
}
