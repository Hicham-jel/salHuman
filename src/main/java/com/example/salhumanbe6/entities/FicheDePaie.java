package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FicheDePaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiche;
    private String periode;
    private double montant_brut;
    private double montant_net;
    private int details_deductions;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmploye_fk", referencedColumnName = "idEmploye")
    private Employe employe;
    @OneToMany(mappedBy = "ficheDePaie")
    private List<ElementSalaire> elementSalaire;

}
