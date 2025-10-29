package com.gdgoc.webServlet.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "requestTextServlet", urlPatterns = "/request-text")
public class RequestTextServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TEXT 조회");

        StringBuilder messageBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            messageBody.append(line);
        }

        String text = messageBody.toString();
        System.out.println("받은 텍스트: " + text);

        response.getWriter().write("ok");
    }
}
