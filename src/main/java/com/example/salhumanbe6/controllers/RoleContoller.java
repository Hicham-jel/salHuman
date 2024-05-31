package com.example.salhumanbe6.controllers;
import com.example.salhumanbe6.dtos.roleDTO;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleContoller {
    private RoleService roleService;

    @Autowired
    public RoleContoller(RoleService roleService) {
        this.roleService = roleService;
    }



    @PostMapping
    public ResponseEntity<roleDTO> createRole(@RequestBody(required = true)  roleDTO role) {
        roleDTO createdRole = roleService.createRole(role);

        return new ResponseEntity<roleDTO>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public List<roleDTO> Allroles() {
        return roleService.getAllRoles();
    }

    @GetMapping(path = "/{idRole}")
    public ResponseEntity<roleDTO> getRole(@PathVariable Long idRole) throws ResourceNotFoundException {

        roleDTO searchedRole = roleService.getRole(idRole);

        if (searchedRole == null) {
            throw new ResourceNotFoundException(idRole+" not found");
        }

        return new ResponseEntity<>(searchedRole, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idRole}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long idRole) throws ResourceNotFoundException {
        if (!roleService.deleteRole(idRole)) {
            throw new ResourceNotFoundException(idRole + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{idRole}")
    public ResponseEntity<roleDTO> updateRole(@PathVariable Long idConge,
                                             @RequestBody(required = true) roleDTO role) throws ResourceNotFoundException {
        roleDTO updateRole = roleService.updateRole(idConge, role);
        if ( updateRole== null) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }

        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }


}
