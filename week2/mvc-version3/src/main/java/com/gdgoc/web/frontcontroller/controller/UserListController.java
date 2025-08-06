package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import com.gdgoc.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserListController implements Controller {
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        List<User> users = userRepository.findAll();

        ModelView mv = new ModelView("users");
        mv.getModel().put("users", users);
        return mv;
    }
}
