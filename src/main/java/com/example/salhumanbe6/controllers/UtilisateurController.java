package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.dtos.utilisateurDTO;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }



    @PostMapping
    public ResponseEntity<utilisateurDTO> createUtilisateur(@RequestBody(required = true) utilisateurDTO utilisateur) {
        utilisateurDTO createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);

        return new ResponseEntity<utilisateurDTO>(createdUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public List<utilisateurDTO> AllUtilisateurs() {
        return utilisateurService.getAllUtilisateur();
    }


    @GetMapping(path = "/{idUtilisateur}")
    public ResponseEntity<utilisateurDTO> getUtilisateur(@PathVariable Long idUtilisateur) throws ResourceNotFoundException {

        utilisateurDTO searchedUtilisateur = utilisateurService.getUtilisateur(idUtilisateur);

        if (searchedUtilisateur == null) {
            throw new ResourceNotFoundException(idUtilisateur+" not found");
        }

        return new ResponseEntity<>(searchedUtilisateur, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idUtilisateur}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long idUtilisateur) throws ResourceNotFoundException {
        if (!utilisateurService.deleteUtilisateur(idUtilisateur)) {
            throw new ResourceNotFoundException(idUtilisateur + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{idUtilisateur}")
    public ResponseEntity<utilisateurDTO> updateUtilisateur(@PathVariable Long idUtilisateur,
                                             @RequestBody(required = true) utilisateurDTO utilisateur) throws ResourceNotFoundException {
        utilisateurDTO updatedUtilisateur = utilisateurService.updateUtilisateur(idUtilisateur, utilisateur);
        if ( updatedUtilisateur== null) {
            throw new ResourceNotFoundException(idUtilisateur + "is not found");
        }

        return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
    }


}
