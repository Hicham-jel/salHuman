package com.example.salhumanbe6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String nomUser;
    private String motDePasse;
    private boolean actif;
    @OneToMany(mappedBy = "utilisateur")
    private List<Role> role;
}
