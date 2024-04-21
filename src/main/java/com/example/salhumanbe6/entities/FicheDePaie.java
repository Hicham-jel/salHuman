package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FicheDePaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiche;
    private String periode;
    private double montant_brut;
    private double montant_net;
    private int details_deductions;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "idEmploye_fk")
    private Employe employe;
    @OneToMany(mappedBy = "FicheDePaie")
    private List<ElementSalaire> elementSalaire;

}
