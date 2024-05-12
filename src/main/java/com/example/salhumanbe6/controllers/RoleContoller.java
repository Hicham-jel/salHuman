package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Role;
import com.example.salhumanbe6.services.CongeService;
import com.example.salhumanbe6.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class RoleContoller {
    private RoleService roleService;

    @Autowired
    public RoleContoller(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path="/roles")
    public List<Role> Allroles() {
        return roleService.getAllRoles();
    }

    @PostMapping("rolecreated")
    public ResponseEntity<Role> createRole(@RequestBody(required = true)  Role role) {
        Role createdRole = roleService.createRole(role);

        return new ResponseEntity<Role>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping(path = "/roles/{idRole}")
    public ResponseEntity<Role> getRole(@PathVariable Long idRole) throws ResourceNotFoundException {

        Role searchedRole = roleService.getRole(idRole);

        if (searchedRole == null) {
            throw new ResourceNotFoundException(idRole+" not found");
        }

        return new ResponseEntity<>(searchedRole, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedRole/{idRole}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long idRole) throws ResourceNotFoundException {
        if (!roleService.deleteRole(idRole)) {
            throw new ResourceNotFoundException(idRole + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/updatedRole/{idRole}")
    public ResponseEntity<Role> updateRole(@PathVariable Long idConge,
                                             @RequestBody(required = true) Role role) throws ResourceNotFoundException {
        Role updateRole = roleService.updateRole(idConge, role);
        if ( updateRole== null) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }

        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }


}
