package com.example.salhumanbe6.services;


import com.example.salhumanbe6.entities.Employe;

import java.util.List;

public interface EmployeService {
    Employe createEmploye(Employe employe);

    boolean deleteEmploye(Long idEmploye);

    List<Employe> getAllEmploye();

    Employe getEmploye(Long idEmploye);

    Employe updateEmploye(Long idEmploye, Employe employe);
}
