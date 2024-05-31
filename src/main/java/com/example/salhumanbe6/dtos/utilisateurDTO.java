package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.entities.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class utilisateurDTO {
    private Long idUtilisateur;
    private String nomUser;
    private String motDePasse;
    private boolean actif;
}
