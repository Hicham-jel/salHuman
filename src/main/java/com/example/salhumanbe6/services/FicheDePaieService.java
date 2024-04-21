package com.example.salhumanbe6.services;



import com.example.salhumanbe6.entities.FicheDePaie;

import java.util.List;

public interface FicheDePaieService {
    FicheDePaie createFicheDePaie(FicheDePaie ficheDePaie);

    boolean deleteFicheDePaie(Long idFiche);

    List<FicheDePaie> getAllFicheDePaies();

    FicheDePaie getFicheDePaie(Long idFiche);

    FicheDePaie updateFicheDePaie(Long idFiche, FicheDePaie ficheDePaie);
}
