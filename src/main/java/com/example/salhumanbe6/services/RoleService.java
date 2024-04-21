package com.example.salhumanbe6.services;

import com.example.salhumanbe6.entities.Role;

import java.util.List;

public interface RoleService{
    Role createRole(Role role);

    boolean deleteRole(Long idRole);

    List<Role> getAllRoles();

    Role getRole(Long idRole);

    Role updateRole(Long idRole, Role role);
}
