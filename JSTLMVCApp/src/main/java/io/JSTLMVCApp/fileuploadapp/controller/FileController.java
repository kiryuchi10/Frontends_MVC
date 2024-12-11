package io.JSTLMVCApp.fileuploadapp.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.JSTLMVCApp.fileuploadapp.repository.FileRepository;
import io.JSTLMVCApp.fileuploadapp.repository.UserRepository;
import io.JSTLMVCApp.model.File;
import io.JSTLMVCApp.model.User;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            File uploadedFile = new File();
            uploadedFile.setFileName(file.getOriginalFilename());
            uploadedFile.setFilePath(filePath.toString());
            uploadedFile.setUploadedAt(LocalDateTime.now());
            uploadedFile.setUploadedBy(user);
            fileRepository.save(uploadedFile);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed");
        }
    }

    @GetMapping("/{userId}")
    public List<File> getFilesByUser(@PathVariable Long userId) {
        return fileRepository.findByUploadedBy_Id(userId);
    }
}
