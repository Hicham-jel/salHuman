package com.example.salhumanbe6.entities;
import java.util.Date;

import com.example.salhumanbe6.enums.TypeH;
import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class HeureTravaillee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idHeureTravaillee;
 private Date date;
 private int nbrHeures;
 private TypeH typeH;
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
 @JoinColumn(referencedColumnName = "idEmploye")
 private Employe employe;
}
