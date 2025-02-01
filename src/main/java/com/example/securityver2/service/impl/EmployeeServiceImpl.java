package com.example.securityver2.service.impl;

import com.example.securityver2.entity.Employee;
import com.example.securityver2.repository.EmployeeRepository;
import com.example.securityver2.service.EmployeeService;
import com.example.securityver2.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public Employee register(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String verify(Employee employee) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(employee.getUsername());
        }
        return "fail";
    }
}
