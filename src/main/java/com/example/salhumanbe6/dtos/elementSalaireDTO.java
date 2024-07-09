package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.enums.TypeE;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter


public class elementSalaireDTO {
    private Long idElementSalaire;
    private double montant;
    private TypeE typeE;
    private Long idFiche;
}
