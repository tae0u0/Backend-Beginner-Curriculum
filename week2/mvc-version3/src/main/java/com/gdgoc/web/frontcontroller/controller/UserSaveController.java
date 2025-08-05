package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import com.gdgoc.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSaveController implements Controller {
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user = new User(name);
        userRepository.save(user);
        request.setAttribute("user", user);
        return new MyView("/WEB-INF/views/save.jsp");
    }
}
