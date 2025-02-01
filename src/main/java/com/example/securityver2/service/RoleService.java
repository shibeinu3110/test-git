package com.example.securityver2.service;

import com.example.securityver2.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getEmployeeRoles(Long employeeId);
}
