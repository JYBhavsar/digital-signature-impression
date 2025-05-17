package com.sign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file,
                               @RequestParam("text") String text,
                               Model model) throws Exception {
        // For now, just echo back the inputs
        model.addAttribute("filename", file.getOriginalFilename());
        model.addAttribute("text", text);
        // TODO: call signatureService.signDataWithRSA(text) or handle document bytes
        return "upload";
    }
}
