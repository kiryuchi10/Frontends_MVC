package io.JSTLMVCApp.model;

public class FileVO {
    private Long id;
    private String fileName;
    private String filePath;
    private Long userId;

    // Constructors
    public FileVO() {}

    public FileVO(Long id, String fileName, String filePath, Long userId) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}


