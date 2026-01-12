package com.substring.chat.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class FileUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/api/files/upload")
    
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        // ✅ validate
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        // ✅ create directory if not exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // ✅ unique file name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // ✅ save file
        Files.copy(file.getInputStream(), filePath);

        // ✅ response
        Map<String, String> response = new HashMap<>();
        response.put("fileUrl", "/uploads/" + fileName);
        response.put("fileName", file.getOriginalFilename());

        return ResponseEntity.ok(response);
    }
}
