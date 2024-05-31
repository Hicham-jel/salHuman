package com.example.salhumanbe6.services;



import com.example.salhumanbe6.dtos.ficheDePaieDTO;

import java.util.List;

public interface FicheDePaieService {
    ficheDePaieDTO createFicheDePaie(ficheDePaieDTO ficheDePaie);

    boolean deleteFicheDePaie(Long idFiche);

    List<ficheDePaieDTO> getAllFicheDePaies();

    ficheDePaieDTO getFicheDePaie(Long idFiche);

    ficheDePaieDTO updateFicheDePaie(Long idFiche, ficheDePaieDTO ficheDePaie);
}
