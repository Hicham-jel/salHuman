package com.example.salhumanbe6.services;

import com.example.salhumanbe6.dtos.congeDTO;

import java.util.List;

public interface CongeService {
    congeDTO createConge(congeDTO conge);

    boolean deleteConge(Long IdConge);

    List<congeDTO> getAllConges();

    congeDTO getConge(Long idConge);

    congeDTO updateConge(Long IdConge, congeDTO conge);
}
