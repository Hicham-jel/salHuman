package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Role;
import com.example.salhumanbe6.repositories.CongeRepository;
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
    public Role createRole(Role role) {
        Role addRole = roleRepository.save(ObjectMapperUtils.map(role,Role.class));
        return ObjectMapperUtils.map(addRole, Role.class);
    }

    @Override
    public boolean deleteRole(Long idRole) {
        Optional<Role> searchedRole = roleRepository.findById(idRole);
        if(searchedRole.isEmpty()) return false;
        roleRepository.delete(searchedRole.get());
        return true;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        List<Role> roles = ObjectMapperUtils.mapAll(roleList, Role.class);
        return roles;
    }

    @Override
    public Role getRole(Long idRole) {
        Optional<Role> searchedRole = roleRepository.findById(idRole);

        if(searchedRole.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedRole.get(), Role.class);
    }

    @Override
    public Role updateRole(Long idRole, Role role) {

            if(!roleRepository.existsById(idRole))
                return null;
            else
                return ObjectMapperUtils.map(roleRepository.save(ObjectMapperUtils.map(role, Role.class)), Role.class);
    }
}
