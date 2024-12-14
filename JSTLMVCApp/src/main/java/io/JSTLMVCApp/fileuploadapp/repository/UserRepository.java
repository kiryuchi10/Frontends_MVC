package io.JSTLMVCApp.fileuploadapp.repository;

import java.util.ArrayList;
import java.util.List;

import io.JSTLMVCApp.model.UserVO;

public class UserRepository {
    private static List<UserVO> users = new ArrayList<>();

    public UserVO save(UserVO user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public UserVO findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
