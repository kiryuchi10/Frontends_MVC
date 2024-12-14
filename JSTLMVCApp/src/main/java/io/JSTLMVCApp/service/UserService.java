package io.JSTLMVCApp.service;

import io.JSTLMVCApp.fileuploadapp.repository.UserRepository;
import io.JSTLMVCApp.model.UserVO;

public class UserService {
	private final UserRepository userRepository = new UserRepository();
	
	 public UserVO registerUser(String username, String password) {
	        UserVO user = new UserVO(null, username, password);
	        return userRepository.save(user);
	    }

	    public UserVO login(String username, String password) {
	        UserVO user = userRepository.findByUsername(username);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null;
	    }

}
