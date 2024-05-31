package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.enums.TypeH;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Data

public class heureTravailleeDTO {
 private Long idHeureTravaillee;
 private Date date;
 private int nbrHeures;
 private TypeH typeH;
}
