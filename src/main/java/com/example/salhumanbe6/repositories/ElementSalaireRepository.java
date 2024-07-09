package com.example.salhumanbe6.repositories;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.ElementSalaire;
import com.example.salhumanbe6.entities.Employe;
import com.example.salhumanbe6.entities.FicheDePaie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementSalaireRepository extends JpaRepository<ElementSalaire,Long> {
    List<ElementSalaire> findAllByFicheDePaie(FicheDePaie ficheDePaie);
}
