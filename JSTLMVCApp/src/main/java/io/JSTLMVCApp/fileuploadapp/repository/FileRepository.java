package io.JSTLMVCApp.fileuploadapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.JSTLMVCApp.model.File;

public interface FileRepository extends JpaRepository <File, Long>{
	List <File> findByUploadedBy_Id (Long UserId);
}
