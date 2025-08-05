package com.gdgoc.web.frontcontroller;

import com.gdgoc.web.frontcontroller.controller.Controller;
import com.gdgoc.web.frontcontroller.controller.UserListController;
import com.gdgoc.web.frontcontroller.controller.UserSaveController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/front-controller/*")
public class FrontControllerServlet extends HttpServlet {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/users/list", new UserListController());
        controllerMap.put("/front-controller/users/save", new UserSaveController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        Controller controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
