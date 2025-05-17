package com.sign.controller;

import com.sign.service.SignatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@Controller
public class UploadController {

    private final SignatureService signatureService;

    public UploadController(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "text", required = false) String text,
            Model model) throws Exception {

        byte[] dataBytes;
        String displayInput;

        if (file != null && !file.isEmpty()) {
            dataBytes = file.getBytes();                       // raw bytes
            displayInput = file.getOriginalFilename();
        } else if (text != null && !text.isBlank()) {
            dataBytes = text.getBytes(StandardCharsets.UTF_8);
            displayInput = text;
        } else {
            model.addAttribute("error", "Please provide text or upload a file");
            return "upload";
        }

        String signature = signatureService.generateRSASignature(dataBytes);

        model.addAttribute("inputLabel", displayInput);
        model.addAttribute("signature", signature);
        return "upload";
    }

    @PostMapping("/verify")
    public String handleVerify(
            @RequestParam(value = "verifyFile", required = false) MultipartFile verifyFile,
            @RequestParam(value = "verifyText", required = false) String verifyText,
            @RequestParam("verifySignature") String sig,
            Model model) throws Exception {

        byte[] dataBytes;
        String displayInput;

        if (verifyFile != null && !verifyFile.isEmpty()) {
            dataBytes = verifyFile.getBytes();
            displayInput = verifyFile.getOriginalFilename();
        } else if (verifyText != null && !verifyText.isBlank()) {
            dataBytes = verifyText.getBytes(StandardCharsets.UTF_8);
            displayInput = verifyText;
        } else {
            model.addAttribute("error", "Please provide text or upload a file");
            return "upload";
        }

        boolean valid = signatureService.verifyRSASignature(dataBytes, sig);

        model.addAttribute("inputLabel", displayInput);
        model.addAttribute("verifySignature", sig);
        model.addAttribute("verificationResult", valid);
        return "upload";
    }
}
