package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    String nom;
    String prenom;
    String departement;
    String poste;
    Date date_embauche;
    @OneToMany(mappedBy = "Employe")
    private List<FicheDePaie> ficheDePaie;
    @OneToMany(mappedBy = "Employe")
    private List<Conge> conge;
}
