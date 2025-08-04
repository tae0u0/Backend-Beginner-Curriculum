package com.gdgoc.xml.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("===== UserServlet init =====");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===== UserServlet service =====");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("===== UserServlet doGet: " + request.getRequestURI() + " =====");
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        User user = new User();
        user.setId(id);
        user.setName(name);

        request.setAttribute("user", user);

        String jspPath = "/WEB-INF/views/user-info.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }

    public static class User {
        private String id;
        private String name;

        public User() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}