package io.JSTLMVCApp.fileuploadapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.JSTLMVCApp.model.FileVO;
import io.JSTLMVCApp.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService = new FileService();

    @PostMapping("/upload")
    public FileVO uploadFile(@RequestParam String fileName, @RequestParam String filePath, @RequestParam Long userId) {
        return fileService.uploadFile(fileName, filePath, userId);
    }

    @GetMapping("/user/{userId}")
    public List<FileVO> getUserFiles(@PathVariable Long userId) {
        return fileService.getUserFiles(userId);
    }
}
