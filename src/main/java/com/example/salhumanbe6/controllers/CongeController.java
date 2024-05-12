package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.services.CongeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CongeController {
    private CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @GetMapping(path="/conges")
    public List<Conge> AllConges() {
        return congeService.getAllConges();
    }

    @PostMapping("/congecreated")
    public ResponseEntity<Conge> createConge(@RequestBody(required = true)  Conge conge) {
        Conge createdConge = congeService.createConge(conge);

        return new ResponseEntity<Conge>(createdConge, HttpStatus.CREATED);
    }

    @GetMapping(path = "/conges/{idConge}")
    public ResponseEntity<Conge> getConge(@PathVariable Long idConge) throws ResourceNotFoundException {

        Conge searchedConge = congeService.getConge(idConge);

        if (searchedConge == null) {
            throw new ResourceNotFoundException(idConge+" not found");
        }

        return new ResponseEntity<>(searchedConge, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedConge/{idConge}")
    public ResponseEntity<Void> deleteConge(@PathVariable Long idConge) throws ResourceNotFoundException {
        if (!congeService.deleteConge(idConge)) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/updatedConge/{idConge}")
    public ResponseEntity<Conge> updateConge(@PathVariable Long idConge,
                                                    @RequestBody(required = true) Conge conge) throws ResourceNotFoundException {
        Conge updatedConge = congeService.updateConge(idConge, conge);
        if ( updatedConge== null) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }

        return new ResponseEntity<>(updatedConge, HttpStatus.OK);
    }


}
