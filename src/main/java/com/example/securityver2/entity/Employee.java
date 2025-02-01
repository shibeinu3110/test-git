package com.example.securityver2.entity;

import com.example.securityver2.repository.RoleRepository;
import com.example.securityver2.service.RoleService;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    //cmt to check branch
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<EmployeeHasRole> employeeHasRoleSet = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return employeeHasRoleSet.stream()
                .map(er -> new SimpleGrantedAuthority("ROLE_" + er.getRole().getRoleTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
