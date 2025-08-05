package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import com.gdgoc.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserListController implements Controller {
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userRepository.findAll();
        request.setAttribute("users", users);
        return new MyView("/WEB-INF/views/users.jsp");
    }
}
