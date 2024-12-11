package io.JSTLMVCApp.fileuploadapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.JSTLMVCApp.model.User;

public interface UserRepository extends JpaRepository <User,Long> {
	User findByUserNameAndPassword(String username, String password);
}
