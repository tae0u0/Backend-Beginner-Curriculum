package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public interface Controller {
    String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException;
}
