package com.example.salhumanbe6.dtos;

import com.example.salhumanbe6.entities.Utilisateur;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
public class roleDTO {
    private Long idRole;
    private String nomRole;
    private String permissions;
}
