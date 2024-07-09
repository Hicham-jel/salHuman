package com.example.salhumanbe6.controllers;


import com.example.salhumanbe6.dtos.employeDTO;
import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.services.CongeService;
import com.example.salhumanbe6.services.EmployeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
@CrossOrigin("*")
public class EmployeController {
    private EmployeService employeService;
    private CongeService congeService;
    private CongeRepository congeRepository;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping(path="/all")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<employeDTO> AllEmploye() {
        return employeService.getAllEmploye();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<employeDTO> createEmploye(@RequestBody(required = true)  employeDTO employe) {
        employeDTO createdEmploye = employeService.createEmploye(employe);
        return new ResponseEntity<employeDTO>(createdEmploye, HttpStatus.CREATED);
    }
    @GetMapping(path="/Name/{idEmploye}")
    public String getEmployeName(@PathVariable Long idEmploye) {
        return employeService.getEmployeName(idEmploye);
    }

    @GetMapping("/{idEmploye}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<employeDTO> getEmploye(@PathVariable Long idEmploye) throws ResourceNotFoundException {
        employeDTO employe = employeService.getEmploye(idEmploye);
        if (employe == null) {
            throw new ResourceNotFoundException(idEmploye+" not found");
        }
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<employeDTO> searchEmploye(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return employeService.searchEmploye("%"+keyword+"%");
    }
    @DeleteMapping(path = "/{idEmploye}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long idEmploye) throws ResourceNotFoundException {
        if (!employeService.deleteEmploye(idEmploye)) {
            throw new ResourceNotFoundException(idEmploye + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idEmploye}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<employeDTO> updateEmploye(@PathVariable Long idEmploye, @RequestBody employeDTO employe) throws ResourceNotFoundException {
        employeDTO updatedEmploye = employeService.updateEmploye(idEmploye, employe);
        if (updatedEmploye == null) {
            throw new ResourceNotFoundException(idEmploye+" not found");
        }
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }
    @GetMapping("/index") // Differentiate the mapping for pagination
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {

        Page<employeDTO> pageEmploye = employeService.findByNomContains(kw, PageRequest.of(page, size));
        model.addAttribute("employes", pageEmploye.getContent());
        model.addAttribute("pages", new int[pageEmploye.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);

        return "employes";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page) {
        congeService.deleteConge(id);
        employeService.deleteEmploye(id);
        return "redirect:/employe?page=" + page + "&keyword=" + keyword;

            }


}

