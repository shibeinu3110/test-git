package com.example.securityver2.service;

import com.example.securityver2.entity.Employee;

public interface EmployeeService {
    Employee register(Employee employee);
    String verify(Employee employee);
}
