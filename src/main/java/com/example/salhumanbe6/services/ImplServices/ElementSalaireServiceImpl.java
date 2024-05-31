package com.example.salhumanbe6.services.ImplServices;


import com.example.salhumanbe6.dtos.elementSalaireDTO;
import com.example.salhumanbe6.entities.ElementSalaire;
import com.example.salhumanbe6.repositories.ElementSalaireRepository;
import com.example.salhumanbe6.services.ElementSalaireService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ElementSalaireServiceImpl implements ElementSalaireService {
    @Autowired
    ElementSalaireRepository elementSalaireRepository;

    @Override
    public elementSalaireDTO createElementSalaire(elementSalaireDTO elementSalaire) {
        ElementSalaire addedElementSalaire= elementSalaireRepository.save(ObjectMapperUtils.map(elementSalaire, ElementSalaire.class));
        return ObjectMapperUtils.map(addedElementSalaire, elementSalaireDTO.class);
    }
    @Override
    public boolean deleteElementSalaire(Long IdElementSalaire) {
        Optional<ElementSalaire> searchedElementSalaire = elementSalaireRepository.findById(IdElementSalaire);

        if(searchedElementSalaire.isEmpty()) return false;
        elementSalaireRepository.delete(searchedElementSalaire.get());
        return true;
    }

    @Override
    public List<elementSalaireDTO> getAllElementSalaire() {
        List<ElementSalaire> elementSalaireList = elementSalaireRepository.findAll();
        List<elementSalaireDTO> elementSalaires = ObjectMapperUtils.mapAll(elementSalaireList, elementSalaireDTO.class);
        return elementSalaires;
    }

    @Override
    public elementSalaireDTO getElementSalaire(Long IdElementSalaire) {
        Optional<ElementSalaire> searchedConge = elementSalaireRepository.findById(IdElementSalaire);

        if(searchedConge.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedConge.get(), elementSalaireDTO.class);
    }

    @Override
    public elementSalaireDTO updateElementSalaire(Long IdElementSalaire, elementSalaireDTO elementSalaire) {
        if(!elementSalaireRepository.existsById(IdElementSalaire))
            return null;
        else
            return ObjectMapperUtils.map(elementSalaireRepository.save(ObjectMapperUtils.map(elementSalaire, ElementSalaire.class)), elementSalaireDTO.class);
    }
}
