package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.dtos.ficheDePaieDTO;
import com.example.salhumanbe6.entities.FicheDePaie;
import com.example.salhumanbe6.repositories.FicheDePaieRepository;
import com.example.salhumanbe6.services.FicheDePaieService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheDePaieServiceImpl implements FicheDePaieService {
    @Autowired
    FicheDePaieRepository ficheDePaieRepository;


    @Override
    public ficheDePaieDTO createFicheDePaie(ficheDePaieDTO ficheDePaie) {
        FicheDePaie addedFicheDePaie = ficheDePaieRepository.save(ObjectMapperUtils.map(ficheDePaie, FicheDePaie.class));
        return ObjectMapperUtils.map(addedFicheDePaie, ficheDePaieDTO.class);
    }

    @Override
    public boolean deleteFicheDePaie(Long IdFicheDePaie) {
        Optional< FicheDePaie> searchedFicheDePaie = ficheDePaieRepository.findById(IdFicheDePaie);

        if(searchedFicheDePaie.isEmpty()) return false;
        ficheDePaieRepository.delete(searchedFicheDePaie.get());
        return true;
    }

    @Override
    public List<ficheDePaieDTO> getAllFicheDePaies() {
        List<FicheDePaie> ficheDePaieList = ficheDePaieRepository.findAll();
        List<ficheDePaieDTO> ficheDePaies = ObjectMapperUtils.mapAll(ficheDePaieList, ficheDePaieDTO.class);
        return ficheDePaies;
    }

    @Override
    public ficheDePaieDTO getFicheDePaie(Long IdFicheDePaie) {
        Optional< FicheDePaie> searchedFicheDePaie = ficheDePaieRepository.findById(IdFicheDePaie);

        if(searchedFicheDePaie.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedFicheDePaie.get(), ficheDePaieDTO.class);
    }

    @Override
    public ficheDePaieDTO updateFicheDePaie(Long IdFicheDePaie, ficheDePaieDTO ficheDePaie) {
        if(!ficheDePaieRepository.existsById(IdFicheDePaie))
            return null;
        else
            return ObjectMapperUtils.map(ficheDePaieRepository.save(ObjectMapperUtils.map(ficheDePaie, FicheDePaie.class)), ficheDePaieDTO.class);
    }
}
