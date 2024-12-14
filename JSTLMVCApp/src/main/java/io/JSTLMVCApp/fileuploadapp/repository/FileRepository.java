package io.JSTLMVCApp.fileuploadapp.repository;

import java.util.ArrayList;
import java.util.List;

import io.JSTLMVCApp.model.FileVO;

public class FileRepository {
    private static List<FileVO> files = new ArrayList<>();

    public FileVO save(FileVO file) {
        file.setId((long) (files.size() + 1));
        files.add(file);
        return file;
    }

    public List<FileVO> findByUserId(Long userId) {
        List<FileVO> userFiles = new ArrayList<>();
        for (FileVO file : files) {
            if (file.getUserId().equals(userId)) {
                userFiles.add(file);
            }
        }
        return userFiles;
    }
}