package com.example.salhumanbe6.services;

import com.example.salhumanbe6.entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur createUtilisateur(Utilisateur utilisateur);

    boolean deleteUtilisateur(Long idUtilisateur);

    List<Utilisateur> getAllUtilisateur();

    Utilisateur getUtilisateur(Long idUtilisateur);

    Utilisateur updateUtilisateur(Long idUtilisateur, Utilisateur utilisateur);
}
