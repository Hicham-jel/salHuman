package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    String nom;
    String prenom;
    String departement;
    String poste;
    Date date_embauche;
    @OneToMany(mappedBy = "employe")
    private List<FicheDePaie> ficheDePaie;

    @OneToMany(mappedBy = "employe")
    private List<Conge> conge;
}
