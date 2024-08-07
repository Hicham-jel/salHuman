package com.example.salhumanbe6.repositories;

import com.example.salhumanbe6.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.example.salhumanbe6.entities.Employe;
public interface CongeRepository extends JpaRepository<Conge, Long> {
    List<Conge> findAllByEmploye(Employe employe);
}
