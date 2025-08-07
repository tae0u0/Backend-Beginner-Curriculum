package com.gdgoc.web.spring.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class SpringUserListController {
    private final UserRepository userRepository = UserRepository.getInstance();

    @GetMapping("/list")
    public ModelAndView process() {
        List<User> users = userRepository.findAll();

        ModelAndView mv = new ModelAndView("users");
        mv.getModel().put("users", users);
        return mv;
    }
}