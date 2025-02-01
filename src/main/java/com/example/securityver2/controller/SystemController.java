package com.example.securityver2.controller;

import com.example.securityver2.entity.Employee;
import com.example.securityver2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class SystemController {
    private final EmployeeService employeeService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Employee register(@RequestBody Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeService.register(employee);
    }
    @PostMapping("/login")
    public String login(@RequestBody Employee employee) {
        return employeeService.verify(employee);
    }
    @PostMapping("/login1")
    public String login() {
        return "employeeService.verify(employee);";
    }
}
