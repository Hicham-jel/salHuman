package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Utilisateur;
import com.example.salhumanbe6.services.CongeService;
import com.example.salhumanbe6.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class UtilisateurController {
    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping(path="/utilisateurs")
    public List<Utilisateur> AllUtilisateurs() {
        return utilisateurService.getAllUtilisateur();
    }

    @PostMapping("utilisateurcreated")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody(required = true)  Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);

        return new ResponseEntity<Utilisateur>(createdUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping(path = "/utilisateurs/{idUtilisateur}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long idUtilisateur) throws ResourceNotFoundException {

        Utilisateur searchedUtilisateur = utilisateurService.getUtilisateur(idUtilisateur);

        if (searchedUtilisateur == null) {
            throw new ResourceNotFoundException(idUtilisateur+" not found");
        }

        return new ResponseEntity<>(searchedUtilisateur, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedUtilisateur/{idUtilisateur}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long idUtilisateur) throws ResourceNotFoundException {
        if (!utilisateurService.deleteUtilisateur(idUtilisateur)) {
            throw new ResourceNotFoundException(idUtilisateur + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/updatedUtilisateur/{idUtilisateur}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long idUtilisateur,
                                             @RequestBody(required = true) Utilisateur utilisateur) throws ResourceNotFoundException {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(idUtilisateur, utilisateur);
        if ( updatedUtilisateur== null) {
            throw new ResourceNotFoundException(idUtilisateur + "is not found");
        }

        return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
    }


}
