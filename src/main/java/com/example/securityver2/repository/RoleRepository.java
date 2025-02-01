package com.example.securityver2.repository;

import com.example.securityver2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select r from Role r inner join EmployeeHasRole er on er.role.id = r.id where er.employee.id = :employeeId")
    List<Role> getRoleByEmployeeId(Long employeeId);
}
