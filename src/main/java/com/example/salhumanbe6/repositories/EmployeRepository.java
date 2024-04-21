package com.example.salhumanbe6.repositories;

import com.example.salhumanbe6.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
