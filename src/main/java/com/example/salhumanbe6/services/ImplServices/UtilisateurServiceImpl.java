package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Utilisateur;
import com.example.salhumanbe6.repositories.CongeRepository;
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
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {

        Utilisateur addUtilisateur = utilisateurRepository.save(ObjectMapperUtils.map(utilisateur, Utilisateur.class));
        return ObjectMapperUtils.map(addUtilisateur, Utilisateur.class);
    }

    @Override
    public boolean deleteUtilisateur(Long idUtilisateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepository.findById(idUtilisateur);
        if(searchedUtilisateur.isEmpty()) return false;
        utilisateurRepository.delete(searchedUtilisateur.get());
        return true;
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        List<Utilisateur> utilisateurs = ObjectMapperUtils.mapAll(utilisateurList, Utilisateur.class);
        return utilisateurs;
    }

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepository.findById(idUtilisateur);

        if(searchedUtilisateur.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedUtilisateur.get(), Utilisateur.class);
    }

    @Override
    public Utilisateur updateUtilisateur(Long idUtilisateur, Utilisateur utilisateur) {

            if(!utilisateurRepository.existsById(idUtilisateur))
                return null;
            else
                return ObjectMapperUtils.map(utilisateurRepository.save(ObjectMapperUtils.map(utilisateur, Utilisateur.class)), Utilisateur.class);
    }
}
