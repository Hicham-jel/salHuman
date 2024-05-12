package com.example.salhumanbe6.services.ImplServices;


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
    public ElementSalaire createElementSalaire(ElementSalaire elementSalaire) {
        ElementSalaire addElementSalairee = elementSalaireRepository.save(ObjectMapperUtils.map(elementSalaire, ElementSalaire.class));
        return ObjectMapperUtils.map(addElementSalairee, ElementSalaire.class);
    }

    @Override
    public boolean deleteElementSalaire(Long idElementSalaire) {
        Optional<ElementSalaire> searchedElementSalaire = elementSalaireRepository.findById(idElementSalaire);
        if(searchedElementSalaire.isEmpty()) return false;
        elementSalaireRepository.delete(searchedElementSalaire.get());
        return true;
    }

    @Override
    public List<ElementSalaire> getAllElementSalaire() {
        List<ElementSalaire> elementSalaireList = elementSalaireRepository.findAll();
        List<ElementSalaire> elementsSalaire = ObjectMapperUtils.mapAll(elementSalaireList, ElementSalaire.class);
        return elementsSalaire;
    }

    @Override
    public ElementSalaire getElementSalaire(Long idElementSalaire) {
        Optional<ElementSalaire> searchedElementSalaire = elementSalaireRepository.findById(idElementSalaire);

        if(searchedElementSalaire.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedElementSalaire.get(), ElementSalaire.class);
    }

    @Override
    public ElementSalaire updateElementSalaire(Long idElementSalaire, ElementSalaire elementSalaire) {
        if(!elementSalaireRepository.existsById(idElementSalaire))
            return null;
        else
            return ObjectMapperUtils.map(elementSalaireRepository.save(ObjectMapperUtils.map(elementSalaire, ElementSalaire.class)), ElementSalaire.class);
    }
}
