package com.example.salhumanbe6.services.ImplServices;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Employe;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.repositories.EmployeRepository;
import com.example.salhumanbe6.services.EmployeService;
import com.example.salhumanbe6.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    EmployeRepository employeRepository;
    @Override
    public Employe createEmploye(Employe employe) {

            Employe addEmploye = employeRepository.save(ObjectMapperUtils.map(employe, Employe.class));
            return ObjectMapperUtils.map(addEmploye, Employe.class);
    }

    @Override
    public boolean deleteEmploye(Long idEmploye) {
        Optional<Employe> searchedEmploye = employeRepository.findById(idEmploye);
        if(searchedEmploye.isEmpty()) return false;
        employeRepository.delete(searchedEmploye.get());
        return true;
    }

    @Override
    public List<Employe> getAllEmploye() {
        List<Employe> employeList = employeRepository.findAll();
        List<Employe> employes = ObjectMapperUtils.mapAll(employeList, Employe.class);
        return employes;
    }

    @Override
    public Employe getEmploye(Long idEmploye) {
        Optional<Employe> searchedEmploye = employeRepository.findById(idEmploye);
        if(searchedEmploye.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedEmploye.get(), Employe.class);
    }

    @Override
    public Employe updateEmploye(Long idEmploye, Employe employe) {
        if(!employeRepository.existsById(idEmploye))
            return null;
        else
            return ObjectMapperUtils.map(employeRepository.save(ObjectMapperUtils.map(employe, Employe.class)), Employe.class);
    }
}
