package com.example.salhumanbe6.controllers;

import com.example.salhumanbe6.entities.ElementSalaire;
import com.example.salhumanbe6.services.ElementSalaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElementSalaireController {
    private ElementSalaireService elementSalaireService;

    public ElementSalaireController(ElementSalaireService elementSalaireService) {
        this.elementSalaireService = elementSalaireService;
    }

    @GetMapping(path="/Allelementservice")
    public List<ElementSalaire> AllElementService() {
        return elementSalaireService.getAllElementSalaire();
    }

    @PostMapping("/elementsalairecreated")
    public ResponseEntity<ElementSalaire> createElementSalaire(@RequestBody(required = true)  ElementSalaire elementSalaire) {
        ElementSalaire createdElementSalaire = elementSalaireService.createElementSalaire(elementSalaire);
        return new ResponseEntity<ElementSalaire>(createdElementSalaire, HttpStatus.CREATED);
    }

    @GetMapping("/getElementSalaire/{idElementSalaire}")
    public ResponseEntity<ElementSalaire> getElementSalaire(@PathVariable Long idElementSalaire) throws ResourceNotFoundException {
        ElementSalaire elementSalaire = elementSalaireService.getElementSalaire(idElementSalaire);
        if (elementSalaire == null) {
            throw new ResourceNotFoundException(idElementSalaire+" not found");
        }
        return new ResponseEntity<>(elementSalaire, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedElementSalaire/{idElementSalaire}")
    public ResponseEntity<Void> deleteElementSalaire(@PathVariable Long idElementSalaire) throws ResourceNotFoundException {
        if (!elementSalaireService.deleteElementSalaire(idElementSalaire)) {
            throw new ResourceNotFoundException(idElementSalaire + " is not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateElementSalaire/{idElementSalaire}")
    public ResponseEntity<ElementSalaire> updateElementSalaire(@PathVariable Long idElementSalaire, @RequestBody ElementSalaire elementSalaire) throws ResourceNotFoundException {
        ElementSalaire updatedElementSalaire = elementSalaireService.updateElementSalaire(idElementSalaire, elementSalaire);
        if (updatedElementSalaire == null) {
            throw new ResourceNotFoundException(idElementSalaire+" not found");
        }
        return new ResponseEntity<>(updatedElementSalaire, HttpStatus.OK);
    }


}

