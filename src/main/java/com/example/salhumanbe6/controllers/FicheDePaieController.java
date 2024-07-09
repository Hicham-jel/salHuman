package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.dtos.ficheDePaieDTO;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.services.FicheDePaieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichedepaie")
@CrossOrigin("*")
public class FicheDePaieController {
    private FicheDePaieService ficheDePaieService;

    public FicheDePaieController(FicheDePaieService ficheDePaieService) {
        this.ficheDePaieService = ficheDePaieService;
    }

    @GetMapping(path="/all")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<ficheDePaieDTO> AllFicheDePaie() {
        return ficheDePaieService.getAllFicheDePaies();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<ficheDePaieDTO> createFicheDePaie(@RequestBody(required = true)  ficheDePaieDTO ficheDePaie) {
        ficheDePaieDTO createdFicheDePaie = ficheDePaieService.createFicheDePaie(ficheDePaie);
        return new ResponseEntity<ficheDePaieDTO>(createdFicheDePaie, HttpStatus.CREATED);
    }

    @GetMapping("/{idFicheDePaie}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<ficheDePaieDTO> getFicheDePaie(@PathVariable Long idFicheDePaie) throws ResourceNotFoundException {
        ficheDePaieDTO ficheDePaie = ficheDePaieService.getFicheDePaie(idFicheDePaie);
        if (ficheDePaie== null) {
            throw new ResourceNotFoundException(idFicheDePaie+" not found");
        }
        return new ResponseEntity<>(ficheDePaie, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idFicheDePaie}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> deleteFicheDePaie(@PathVariable Long idFicheDePaie) throws ResourceNotFoundException {
        if (!ficheDePaieService.deleteFicheDePaie(idFicheDePaie)) {
            throw new ResourceNotFoundException(idFicheDePaie + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idFicheDePaie}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<ficheDePaieDTO> updateFicheDePaie(@PathVariable Long idFicheDePaie, @RequestBody ficheDePaieDTO ficheDePaie) throws ResourceNotFoundException {
        ficheDePaieDTO updateFicheDePaie = ficheDePaieService.updateFicheDePaie(idFicheDePaie,ficheDePaie );
        if (updateFicheDePaie == null) {
            throw new ResourceNotFoundException(idFicheDePaie+" not found");
        }
        return new ResponseEntity<>(updateFicheDePaie, HttpStatus.OK);
    }


}


