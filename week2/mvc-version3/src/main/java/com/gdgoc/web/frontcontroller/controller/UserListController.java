package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;

import java.util.List;
import java.util.Map;

public class UserListController implements Controller {
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<User> users = userRepository.findAll();

        model.put("users", users);
        return "users";
    }
}
