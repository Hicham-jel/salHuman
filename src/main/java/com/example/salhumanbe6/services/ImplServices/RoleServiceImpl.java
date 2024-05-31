package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.dtos.roleDTO;
import com.example.salhumanbe6.entities.Role;
import com.example.salhumanbe6.repositories.RoleRepository;
import com.example.salhumanbe6.services.RoleService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public roleDTO createRole(roleDTO role) {
        Role addedRole = roleRepository.save(ObjectMapperUtils.map( role,  Role.class));
        return ObjectMapperUtils.map(addedRole, roleDTO.class);
    }

    @Override
    public boolean deleteRole(Long IdRole) {
        Optional<  Role> searchedRole = roleRepository.findById(IdRole);

        if(searchedRole.isEmpty()) return false;
        roleRepository.delete(searchedRole.get());
        return true;
    }

    @Override
    public List<roleDTO> getAllRoles() {
        List< Role> roleList = roleRepository.findAll();
        List<roleDTO> roles = ObjectMapperUtils.mapAll(roleList, roleDTO.class);
        return roles;
    }

    @Override
    public roleDTO getRole(Long IdRole) {
        Optional< Role> searchedEmploye = roleRepository.findById(IdRole);

        if(searchedEmploye.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedEmploye.get(), roleDTO.class);
    }

    @Override
    public roleDTO updateRole(Long IdRole, roleDTO role) {
        if(!roleRepository.existsById(IdRole))
            return null;
        else
            return ObjectMapperUtils.map(roleRepository.save(ObjectMapperUtils.map(role, Role.class)), roleDTO.class);
    }
}
