package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.dtos.employeDTO;
import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.ElementSalaire;
import com.example.salhumanbe6.entities.Employe;
import com.example.salhumanbe6.entities.FicheDePaie;
import com.example.salhumanbe6.mappers.transf;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.repositories.ElementSalaireRepository;
import com.example.salhumanbe6.repositories.EmployeRepository;
import com.example.salhumanbe6.repositories.FicheDePaieRepository;
import com.example.salhumanbe6.services.EmployeService;
import com.example.salhumanbe6.services.FicheDePaieService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    EmployeRepository employeRepository;
    @Autowired
    CongeRepository congeRepository;
    @Autowired
    FicheDePaieRepository ficheDePaieRepository;
    @Autowired
    ElementSalaireRepository elementSalaireRepository;
    private transf dtoMapper;

    @Override
    public List<employeDTO> searchEmploye(String s) {
        List<Employe> employeList = employeRepository.searchEmploye(s);
        List<employeDTO> employes = ObjectMapperUtils.mapAll(employeList, employeDTO.class);
        return employes;
    }

    @Override
    public employeDTO createEmploye(employeDTO employe) {
        Employe addedEmploye = employeRepository.save(ObjectMapperUtils.map(employe, Employe.class));
        return ObjectMapperUtils.map(addedEmploye, employeDTO.class);
    }

    @Override
    public boolean deleteEmploye(Long IdEmploye) {
        Optional< Employe> searchedEmploye = employeRepository.findById(IdEmploye);

        if(searchedEmploye.isEmpty()) return false;
        List<Conge> conges = congeRepository.findAllByEmploye(searchedEmploye.get());
        List<FicheDePaie> fichedepaie= ficheDePaieRepository.findAllByEmploye(searchedEmploye.get());
        if(!conges.isEmpty()) {
            congeRepository.deleteAll(conges);
            ficheDePaieRepository.deleteAll(fichedepaie);
        }
        employeRepository.delete(searchedEmploye.get());
        return true;
    }

    @Override
    public List<employeDTO> getAllEmploye() {
        List<Employe> employeList = employeRepository.findAll();
        List<employeDTO> employes = ObjectMapperUtils.mapAll(employeList, employeDTO.class);
        return employes;
    }

    @Override
    public employeDTO getEmploye(Long IdEmploye) {
        Optional< Employe> searchedEmploye = employeRepository.findById(IdEmploye);

        if(searchedEmploye.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedEmploye.get(), employeDTO.class);
    }

    @Override
    public String getEmployeName(Long idEmploye) {
        Optional< Employe> searchedEmploye = employeRepository.findById(idEmploye);

        if(searchedEmploye.isEmpty()) return null;
        return searchedEmploye.get().getNom();
    }

    @Override
    public employeDTO updateEmploye(Long IdEmploye, employeDTO employe) {
        if(!employeRepository.existsById(IdEmploye))
            return null;
        else
            return ObjectMapperUtils.map(employeRepository.save(ObjectMapperUtils.map(employe, Employe.class)), employeDTO.class);
    }

    @Override
    public Page<employeDTO> findByNomContains(String keyword, PageRequest pageRequest) {
            Page<Employe> employesPage = employeRepository.findByNomContains(keyword, pageRequest);
            return employesPage.map(employe -> ObjectMapperUtils.map(employe, employeDTO.class));

    }
}
