package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.dtos.congeDTO;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.services.CongeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conges")
@CrossOrigin("*")
public class CongeController {
    private CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }



    @PostMapping
    public ResponseEntity<congeDTO> createConge(@RequestBody(required = true) congeDTO conge) {
        congeDTO createdConge = congeService.createConge(conge);
        return new ResponseEntity<congeDTO>(createdConge, HttpStatus.CREATED);
    }
    @GetMapping(path="/all")
    public List<congeDTO> AllConges() {
        return congeService.getAllConges();
    }

    @GetMapping(path = "/{idConge}")
    public ResponseEntity<congeDTO> getConge(@PathVariable Long idConge) throws ResourceNotFoundException {

        congeDTO searchedConge = congeService.getConge(idConge);

        if (searchedConge == null) {
            throw new ResourceNotFoundException(idConge+" not found");
        }

        return new ResponseEntity<>(searchedConge, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idConge}")
    public ResponseEntity<Void> deleteConge(@PathVariable Long idConge) throws ResourceNotFoundException {
        if (!congeService.deleteConge(idConge)) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{idConge}")
    public ResponseEntity<congeDTO> updateConge(@PathVariable Long idConge,
                                                    @RequestBody(required = true) congeDTO conge) throws ResourceNotFoundException {
        congeDTO updatedConge = congeService.updateConge(idConge, conge);
        if ( updatedConge== null) {
            throw new ResourceNotFoundException(idConge + "is not found");
        }

        return new ResponseEntity<>(updatedConge, HttpStatus.OK);
    }


}
