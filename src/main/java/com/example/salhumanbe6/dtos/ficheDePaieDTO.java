package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.entities.ElementSalaire;
import com.example.salhumanbe6.entities.Employe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter


public class ficheDePaieDTO {
    private Long idFiche;
    private String periode;
    private double montant_brut;
    private double montant_net;
    private int details_deductions;
    private Long idEmploye;
}
