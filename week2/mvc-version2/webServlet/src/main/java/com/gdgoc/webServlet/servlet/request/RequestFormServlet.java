package com.gdgoc.webServlet.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestFormServlet", urlPatterns = "/request-form")
public class RequestFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HTML Form 조회");
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        System.out.println("id : " + id + ", name : " + name);
        response.getWriter().write("ok");
    }
}
