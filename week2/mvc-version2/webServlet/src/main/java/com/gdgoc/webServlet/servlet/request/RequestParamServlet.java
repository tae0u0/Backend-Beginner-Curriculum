package com.gdgoc.webServlet.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("단일 파라미터 조회");
        String singleName = request.getParameter("name");
        System.out.println(singleName);

        System.out.println("복수 파라미터 조회");
        String[] names = request.getParameterValues("name");
        for (String name : names) {
            System.out.println(name);
        }

        response.getWriter().write("ok");
    }
}
