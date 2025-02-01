package com.example.securityver2.service.impl;

import com.example.securityver2.entity.Role;
import com.example.securityver2.repository.RoleRepository;
import com.example.securityver2.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> getEmployeeRoles(Long employeeId) {
        return roleRepository.getRoleByEmployeeId(employeeId);
    }
}
