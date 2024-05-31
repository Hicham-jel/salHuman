package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.entities.Conge;
import com.example.salhumanbe6.entities.FicheDePaie;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter

public class employeDTO {
    private Long idEmploye;
    String nom;
    String prenom;
    String departement;
    String poste;
    Date date_embauche;
}
