package io.JSTLMVCApp.fileuploadapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.JSTLMVCApp.fileuploadapp.repository.UserRepository;
import io.JSTLMVCApp.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody User user){
		User existingUser= userRepository.findByUserNameAndPassword(user.getUsername(), user.getPassword());
		if (existingUser !=null) {
			return ResponseEntity.ok(existingUser);
		}
		return ResponseEntity.status(401).body("Invalid Credentials");
	}
	
}
