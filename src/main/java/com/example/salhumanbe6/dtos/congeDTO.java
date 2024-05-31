package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.entities.Employe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class congeDTO {
private Long idConge;
private String typeDeConge;
private Date dateDebut;
private Date dateFin;
private String statut;
    private Long idEmploye;
}
