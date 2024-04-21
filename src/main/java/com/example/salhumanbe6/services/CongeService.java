package com.example.salhumanbe6.services;

import com.example.salhumanbe6.entities.Conge;

import java.util.List;

public interface CongeService {
    Conge createConge(Conge conge);

    boolean deleteConge(Long idConge);

    List<Conge> getAllConges();

    Conge getConge(Long idConge);

    Conge updateConge(Long idConge, Conge conge);
}
