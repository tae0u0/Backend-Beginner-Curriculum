package com.gdgoc.web.servlet;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userListServlet", urlPatterns = "/users/list")
public class userListServlet extends HttpServlet {
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userRepository.findAll();
        request.setAttribute("users", users);

        String viewPath = "/WEB-INF/views/users.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}