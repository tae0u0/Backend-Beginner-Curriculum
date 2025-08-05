package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserListController implements Controller {
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userRepository.findAll();

        request.setAttribute("users", users);

        String viewPath = "/WEB-INF/views/users.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
