package com.example.salhumanbe6.services;

import com.example.salhumanbe6.dtos.roleDTO;

import java.util.List;

public interface RoleService{
    roleDTO createRole(roleDTO role);

    boolean deleteRole(Long idRole);

    List<roleDTO> getAllRoles();

    roleDTO getRole(Long idRole);

    roleDTO updateRole(Long idRole, roleDTO role);
}
