package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.dtos.congeDTO;
import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.mappers.transf;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.services.CongeService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeServiceImpl implements CongeService {

    @Autowired
    CongeRepository congeRepository;
    transf dtoMapper;

    @Override
    public congeDTO createConge(congeDTO conge) {
        Conge addedConge = congeRepository.save(ObjectMapperUtils.map(conge, Conge.class));
        return ObjectMapperUtils.map(addedConge, congeDTO.class);
    }

    @Override
    public boolean deleteConge(Long IdConge) {
        Optional<Conge> searchedConge = congeRepository.findById(IdConge);
        if(searchedConge.isEmpty()) return false;
        congeRepository.delete(searchedConge.get());
        return true;
    }
    @Override
    public List<congeDTO> getAllConges() {
        List<Conge> congeList = congeRepository.findAll();
        List<congeDTO> conges = ObjectMapperUtils.mapAll(congeList, congeDTO.class);
        return conges;
    }

    @Override
    public congeDTO getConge(Long idConge) {
        Optional<Conge> searchedConge = congeRepository.findById(idConge);

        if(searchedConge.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedConge.get(), congeDTO.class);
    }

    @Override
    public congeDTO updateConge(Long idConge, congeDTO conge) {
        if(!congeRepository.existsById(idConge))
            return null;
        else
            return ObjectMapperUtils.map(congeRepository.save(ObjectMapperUtils.map(conge, Conge.class)), congeDTO.class);
    }
}



