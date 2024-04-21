package com.example.salhumanbe6.services;

import com.example.salhumanbe6.entities.ElementSalaire;

import java.util.List;

public interface ElementSalaireService {
    ElementSalaire createElementSalaire(ElementSalaire elementSalaire);

    boolean deleteElementSalaire(Long idElementSalaire);

    List<ElementSalaire> getAllElementSalaire();

    ElementSalaire getElementSalaire(Long idElementSalaire);

    ElementSalaire updateElementSalaire(Long idElementSalaire, ElementSalaire elementSalaire);
}
