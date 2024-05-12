package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor

public class ElementSalaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementSalaire;
    private double montant;
    private TypeE typeE;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idFiche_fk", referencedColumnName = "idFiche")
    private FicheDePaie ficheDePaie;
}
