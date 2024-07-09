package com.example.salhumanbe6.services;


import com.example.salhumanbe6.dtos.employeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EmployeService {
     List<employeDTO> searchEmploye(String s) ;

    employeDTO createEmploye(employeDTO employe);

    boolean deleteEmploye(Long idEmploye);

    List<employeDTO> getAllEmploye();

    employeDTO getEmploye(Long idEmploye);

    String getEmployeName(Long idEmploye);

    employeDTO updateEmploye(Long idEmploye, employeDTO employe);

    Page<employeDTO> findByNomContains(String keyword, PageRequest pageRequest);
}
