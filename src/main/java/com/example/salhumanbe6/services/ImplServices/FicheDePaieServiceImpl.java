package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.FicheDePaie;
import com.example.salhumanbe6.repositories.EmployeRepository;
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
    public FicheDePaie createFicheDePaie(FicheDePaie ficheDePaie) {
        FicheDePaie addficheDePaie = ficheDePaieRepository.save(ObjectMapperUtils.map(ficheDePaie, FicheDePaie.class));
        return ObjectMapperUtils.map(addficheDePaie, FicheDePaie.class);
    }

    @Override
    public boolean deleteFicheDePaie(Long idFiche) {
        Optional<FicheDePaie> searchedFicheDePaie = ficheDePaieRepository.findById(idFiche);
        if(searchedFicheDePaie.isEmpty()) return false;
        ficheDePaieRepository.delete(searchedFicheDePaie.get());
        return true;
    }

    @Override
    public List<FicheDePaie> getAllFicheDePaies() {
        List<FicheDePaie> ficheList = ficheDePaieRepository.findAll();
        List<FicheDePaie> fiches = ObjectMapperUtils.mapAll(ficheList, FicheDePaie.class);
        return fiches;
    }

    @Override
    public FicheDePaie getFicheDePaie(Long idFiche) {
        Optional<FicheDePaie> searchedFicheDePaie = ficheDePaieRepository.findById(idFiche);

        if(searchedFicheDePaie.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedFicheDePaie.get(), FicheDePaie.class);
    }

    @Override
    public FicheDePaie updateFicheDePaie(Long idFiche, FicheDePaie ficheDePaie) {
        if(!ficheDePaieRepository.existsById(idFiche))
            return null;
        else
            return ObjectMapperUtils.map(ficheDePaieRepository.save(ObjectMapperUtils.map(ficheDePaie, FicheDePaie.class)), FicheDePaie.class);
    }
}
