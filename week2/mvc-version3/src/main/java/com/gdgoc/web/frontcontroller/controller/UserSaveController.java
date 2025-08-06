package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class UserSaveController implements ControllerV2 {
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        String name = paramMap.get("name");
        User user = new User(name);
        userRepository.save(user);

        model.put("user", user);
        return "save";
    }
}
