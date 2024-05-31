package com.example.salhumanbe6.services;

import com.example.salhumanbe6.dtos.utilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    utilisateurDTO createUtilisateur(utilisateurDTO utilisateur);

    boolean deleteUtilisateur(Long idUtilisateur);

    List<utilisateurDTO> getAllUtilisateur();

    utilisateurDTO getUtilisateur(Long idUtilisateur);

    utilisateurDTO updateUtilisateur(Long idUtilisateur, utilisateurDTO utilisateur);
}
