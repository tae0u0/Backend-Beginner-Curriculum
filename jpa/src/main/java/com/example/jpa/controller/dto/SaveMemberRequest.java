package com.example.jpa.controller.dto;

public record SaveMemberRequest(
        String name,
        Long teamId
) {
}
