package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.entities.Conge;
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
    @Override
    public Conge createConge(Conge conge){
        Conge addConge = congeRepository.save(ObjectMapperUtils.map(conge, Conge.class));
        return ObjectMapperUtils.map(addConge, Conge.class);
    }

    @Override
    public boolean deleteConge(Long idConge) {
        Optional<Conge> searchedConge = congeRepository.findById(idConge);
        if(searchedConge.isEmpty()) return false;
        congeRepository.delete(searchedConge.get());
        return true;
    }

    @Override
    public List<Conge> getAllConges() {
        List<Conge> congeList = congeRepository.findAll();
        List<Conge> conges = ObjectMapperUtils.mapAll(congeList, Conge.class);
        return conges;
    }

    @Override
    public Conge getConge(Long idConge) {
        Optional<Conge> searchedConge = congeRepository.findById(idConge);

        if(searchedConge.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedConge.get(), Conge.class);
    }

    @Override
    public Conge updateConge(Long idConge, Conge conge) {
        if(!congeRepository.existsById(idConge))
            return null;
        else
            return ObjectMapperUtils.map(congeRepository.save(ObjectMapperUtils.map(conge, Conge.class)), Conge.class);
    }
    }



