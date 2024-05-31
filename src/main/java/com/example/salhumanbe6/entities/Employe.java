package com.example.salhumanbe6.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe")
    private List<FicheDePaie> ficheDePaie;

    @OneToMany(mappedBy = "employe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Conge> conge;
}
