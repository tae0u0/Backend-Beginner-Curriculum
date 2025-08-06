package com.gdgoc.web.frontcontroller.controller;

import com.gdgoc.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public interface Controller {
    ModelView process(Map<String, String> paramMap) throws ServletException, IOException;
}
