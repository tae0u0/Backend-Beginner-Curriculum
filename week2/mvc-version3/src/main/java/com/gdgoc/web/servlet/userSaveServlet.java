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

@WebServlet(name = "userSaveServlet", urlPatterns = "/users/save")
public class userSaveServlet extends HttpServlet {
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        User user = new User(name);

        userRepository.save(user);
        request.setAttribute("user", user);

        String viewPath = "/WEB-INF/views/save.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}