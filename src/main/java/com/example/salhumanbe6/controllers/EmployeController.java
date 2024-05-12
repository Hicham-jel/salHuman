package com.example.salhumanbe6.controllers;


import com.example.salhumanbe6.entities.Employe;
import com.example.salhumanbe6.services.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping(path="/AllEmploye")
    public List<Employe> AllEmploye() {
        return employeService.getAllEmploye();
    }

    @PostMapping("employecreated")
    public ResponseEntity<Employe> createEmploye(@RequestBody(required = true)  Employe employe) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return new ResponseEntity<Employe>(createdEmploye, HttpStatus.CREATED);
    }

    @GetMapping("/getEmploye/{idEmploye}")
    public ResponseEntity<Employe> getEmploye(@PathVariable Long idEmploye) throws ResourceNotFoundException {
        Employe employe = employeService.getEmploye(idEmploye);
        if (employe == null) {
            throw new ResourceNotFoundException(idEmploye+" not found");
        }
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedEmploye/{idEmploye}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long idEmploye) throws ResourceNotFoundException {
        if (!employeService.deleteEmploye(idEmploye)) {
            throw new ResourceNotFoundException(idEmploye + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateEmploye/{idEmploye}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long idEmploye, @RequestBody Employe employe) throws ResourceNotFoundException {
        Employe updatedEmploye = employeService.updateEmploye(idEmploye, employe);
        if (updatedEmploye == null) {
            throw new ResourceNotFoundException(idEmploye+" not found");
        }
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }


}

