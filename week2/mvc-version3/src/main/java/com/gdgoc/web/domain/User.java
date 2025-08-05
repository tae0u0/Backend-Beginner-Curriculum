package com.gdgoc.web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}