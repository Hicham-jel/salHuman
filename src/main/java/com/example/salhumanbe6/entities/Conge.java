package com.example.salhumanbe6.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idConge;
private String typeDeConge;
private Date dateDebut;
private Date dateFin;
private String statut;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmploye_fk", referencedColumnName = "idEmploye")
    private Employe employe;
}
