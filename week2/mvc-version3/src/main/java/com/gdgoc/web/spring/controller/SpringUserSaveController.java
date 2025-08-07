package com.gdgoc.web.spring.controller;

import com.gdgoc.web.domain.User;
import com.gdgoc.web.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class SpringUserSaveController {
    private UserRepository userRepository = UserRepository.getInstance();

    @PostMapping("/save")
    public String process(@RequestBody String name, Map<String, Object> model) {
        User user = new User(name);
        userRepository.save(user);

        model.put("user", user);
        return "save";
    }
}
