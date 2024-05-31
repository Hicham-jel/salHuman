package com.example.salhumanbe6.repositories;

import com.example.salhumanbe6.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
    Page<Employe> findByNomContains(String keyword, Pageable pageable);
    @Query("select e from Employe e where e.nom like :kw")
    List<Employe> searchEmploye(@Param("kw") String keyword);
}
