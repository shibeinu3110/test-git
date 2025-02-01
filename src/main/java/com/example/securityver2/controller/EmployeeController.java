package com.example.securityver2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class EmployeeController {
    @GetMapping("/check")
    public String testUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "Check user role success" + authentication.getName();
    }
}
