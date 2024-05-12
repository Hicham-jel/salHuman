package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.entities.Employe;
import com.example.salhumanbe6.entities.FicheDePaie;
import com.example.salhumanbe6.services.EmployeService;
import com.example.salhumanbe6.services.FicheDePaieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FicheDePaieController {
    private FicheDePaieService ficheDePaieService;

    public FicheDePaieController(FicheDePaieService ficheDePaieService) {
        this.ficheDePaieService = ficheDePaieService;
    }

    @GetMapping(path="/AllFicheDePaie")
    public List<FicheDePaie> AllFicheDePaie() {
        return ficheDePaieService.getAllFicheDePaies();
    }

    @PostMapping("fichedepaiecreated")
    public ResponseEntity<FicheDePaie> createFicheDePaie(@RequestBody(required = true)  FicheDePaie ficheDePaie) {
        FicheDePaie createdFicheDePaie = ficheDePaieService.createFicheDePaie(ficheDePaie);
        return new ResponseEntity<FicheDePaie>(createdFicheDePaie, HttpStatus.CREATED);
    }

    @GetMapping("/getFicheDePaie/{idFicheDePaie}")
    public ResponseEntity<FicheDePaie> getFicheDePaie(@PathVariable Long idFicheDePaie) throws ResourceNotFoundException {
        FicheDePaie ficheDePaie = ficheDePaieService.getFicheDePaie(idFicheDePaie);
        if (ficheDePaie== null) {
            throw new ResourceNotFoundException(idFicheDePaie+" not found");
        }
        return new ResponseEntity<>(ficheDePaie, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedFicheDePaie/{idFicheDePaie}")
    public ResponseEntity<Void> deleteFicheDePaie(@PathVariable Long idFicheDePaie) throws ResourceNotFoundException {
        if (!ficheDePaieService.deleteFicheDePaie(idFicheDePaie)) {
            throw new ResourceNotFoundException(idFicheDePaie + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateFicheDePaie/{idFicheDePaie}")
    public ResponseEntity<FicheDePaie> updateFicheDePaie(@PathVariable Long idFicheDePaie, @RequestBody FicheDePaie ficheDePaie) throws ResourceNotFoundException {
        FicheDePaie updateFicheDePaie = ficheDePaieService.updateFicheDePaie(idFicheDePaie,ficheDePaie );
        if (updateFicheDePaie == null) {
            throw new ResourceNotFoundException(idFicheDePaie+" not found");
        }
        return new ResponseEntity<>(updateFicheDePaie, HttpStatus.OK);
    }


}


