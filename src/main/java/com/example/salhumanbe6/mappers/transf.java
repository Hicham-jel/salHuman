package com.example.salhumanbe6.mappers;

import com.example.salhumanbe6.dtos.congeDTO;
import com.example.salhumanbe6.dtos.employeDTO;
import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.Employe;
import org.springframework.beans.BeanUtils;

public class transf {
    public employeDTO fromEmploye(Employe employe) {
        employeDTO employeDTO = new employeDTO();
        BeanUtils.copyProperties(employe, employeDTO);
        return employeDTO;
    }

    public Employe fromEmployeDTO(employeDTO employeDTO) {
        Employe employe = new Employe();
        BeanUtils.copyProperties(employeDTO, employe);
        return employe;
    }
    public congeDTO fromConge(Conge conge) {
        congeDTO congeDTO = new congeDTO();
        BeanUtils.copyProperties(conge, congeDTO);
        if (conge.getEmploye() != null) {
            congeDTO.setIdEmploye(conge.getEmploye().getIdEmploye()); // Assurez-vous que l'ID de l'employé est également copié
        }
        return congeDTO;
    }

    public Conge fromcongeDTO(congeDTO congeDTO) {
        Conge conge = new Conge();
        BeanUtils.copyProperties(congeDTO, conge);
        return conge;
    }
}
