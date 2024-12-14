package io.JSTLMVCApp.service;

import java.util.List;

import io.JSTLMVCApp.fileuploadapp.repository.FileRepository;
import io.JSTLMVCApp.model.FileVO;

public class FileService {
    private final FileRepository fileRepository = new FileRepository();

    public FileVO uploadFile(String fileName, String filePath, Long userId) {
        FileVO file = new FileVO(null, fileName, filePath, userId);
        return fileRepository.save(file);
    }

    public List<FileVO> getUserFiles(Long userId) {
        return fileRepository.findByUserId(userId);
    }
}