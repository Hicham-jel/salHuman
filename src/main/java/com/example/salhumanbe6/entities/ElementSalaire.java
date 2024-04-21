package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementSalaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElementSalaire;
    private double montant;
    private TypeE typeE;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "idFiche")
    private FicheDePaie ficheDePaie;
}
