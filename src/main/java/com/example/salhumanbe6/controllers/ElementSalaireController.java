package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.dtos.elementSalaireDTO;
import com.example.salhumanbe6.exceptions.ResourceNotFoundException;
import com.example.salhumanbe6.services.ElementSalaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elementsalaire")
public class ElementSalaireController {
    private ElementSalaireService elementSalaireService;

    public ElementSalaireController(ElementSalaireService elementSalaireService) {
        this.elementSalaireService = elementSalaireService;
    }


    @PostMapping
    public ResponseEntity<elementSalaireDTO> createElementSalaire(@RequestBody(required = true)  elementSalaireDTO elementSalaire) {
        elementSalaireDTO createdElementSalaire = elementSalaireService.createElementSalaire(elementSalaire);
        return new ResponseEntity<elementSalaireDTO>(createdElementSalaire, HttpStatus.CREATED);
    }


    @GetMapping(path="/all")
    public List<elementSalaireDTO> AllElementService() {
        return elementSalaireService.getAllElementSalaire();
    }

    @GetMapping("/{idElementSalaire}")
    public ResponseEntity<elementSalaireDTO> getElementSalaire(@PathVariable Long idElementSalaire) throws ResourceNotFoundException {
        elementSalaireDTO elementSalaire = elementSalaireService.getElementSalaire(idElementSalaire);
        if (elementSalaire == null) {
            throw new ResourceNotFoundException(idElementSalaire+" not found");
        }
        return new ResponseEntity<>(elementSalaire, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idElementSalaire}")
    public ResponseEntity<Void> deleteElementSalaire(@PathVariable Long idElementSalaire) throws ResourceNotFoundException {
        if (!elementSalaireService.deleteElementSalaire(idElementSalaire)) {
            throw new ResourceNotFoundException(idElementSalaire + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idElementSalaire}")
    public ResponseEntity<elementSalaireDTO> updateElementSalaire(@PathVariable Long idElementSalaire, @RequestBody elementSalaireDTO elementSalaire) throws ResourceNotFoundException {
        elementSalaireDTO updatedElementSalaire = elementSalaireService.updateElementSalaire(idElementSalaire, elementSalaire);
        if (updatedElementSalaire == null) {
            throw new ResourceNotFoundException(idElementSalaire+" not found");
        }
        return new ResponseEntity<>(updatedElementSalaire, HttpStatus.OK);
    }


}

