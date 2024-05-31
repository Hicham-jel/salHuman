package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.dtos.utilisateurDTO;
import com.example.salhumanbe6.entities.Utilisateur;
import com.example.salhumanbe6.repositories.UtilisateurRepository;
import com.example.salhumanbe6.services.UtilisateurService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public utilisateurDTO createUtilisateur(utilisateurDTO utilisateur) {
        Utilisateur addedUtilisateur = utilisateurRepository.save(ObjectMapperUtils.map( utilisateur,  Utilisateur.class));
        return ObjectMapperUtils.map(addedUtilisateur, utilisateurDTO.class);
    }

    @Override
    public boolean deleteUtilisateur(Long IdUtilisateur) {
        Optional< Utilisateur> searchedUtilisateur = utilisateurRepository.findById(IdUtilisateur);

        if(searchedUtilisateur.isEmpty()) return false;
        utilisateurRepository.delete(searchedUtilisateur.get());
        return true;
    }

    @Override
    public List<utilisateurDTO> getAllUtilisateur() {
        List< Utilisateur> utilisateurList = utilisateurRepository.findAll();
        List<utilisateurDTO> utilisateurs = ObjectMapperUtils.mapAll(utilisateurList, utilisateurDTO.class);
        return utilisateurs;
    }

    @Override
    public utilisateurDTO getUtilisateur(Long IdUtilisateur) {
        Optional< Utilisateur> searchedUtilisateur = utilisateurRepository.findById(IdUtilisateur);

        if(searchedUtilisateur.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedUtilisateur.get(), utilisateurDTO.class);
    }

    @Override
    public utilisateurDTO updateUtilisateur(Long IdUtilisateur, utilisateurDTO utilisateur) {
        if(!utilisateurRepository.existsById(IdUtilisateur))
            return null;
        else
            return ObjectMapperUtils.map(utilisateurRepository.save(ObjectMapperUtils.map(utilisateur, Utilisateur.class)), utilisateurDTO.class);
    }
}
