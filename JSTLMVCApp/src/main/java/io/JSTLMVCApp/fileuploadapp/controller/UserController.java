package io.JSTLMVCApp.fileuploadapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.JSTLMVCApp.model.UserVO;
import io.JSTLMVCApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService = new UserService();

	/*
	 * @PostMapping("/register") public UserVO register(@RequestParam String
	 * username, @RequestParam String password) { return
	 * userService.registerUser(username, password); }
	 */
    
    @PostMapping("/register")
    public String register(@RequestBody UserVO userVO) {
        try {
            userService.registerUser(userVO.getUsername(), userVO.getPassword());
            return "User registered successfully!";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }
	/*
	 * @PostMapping("/login") public UserVO login(@RequestParam String
	 * username, @RequestParam String password) { UserVO user =
	 * userService.login(username, password); if (user == null) { throw new
	 * RuntimeException("Invalid credentials"); } return user; }
	 */
    
    @PostMapping("/login")
    public UserVO login(@RequestBody UserVO userVO) {
        UserVO user = userService.login(userVO.getUsername(), userVO.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}
