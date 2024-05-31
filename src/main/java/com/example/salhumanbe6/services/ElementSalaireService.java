package com.example.salhumanbe6.services;

import com.example.salhumanbe6.dtos.elementSalaireDTO;

import java.util.List;

public interface ElementSalaireService {
    elementSalaireDTO createElementSalaire(elementSalaireDTO elementSalaire);

    boolean deleteElementSalaire(Long idElementSalaire);

    List<elementSalaireDTO> getAllElementSalaire();

    elementSalaireDTO getElementSalaire(Long idElementSalaire);

    elementSalaireDTO updateElementSalaire(Long idElementSalaire, elementSalaireDTO elementSalaire);
}
