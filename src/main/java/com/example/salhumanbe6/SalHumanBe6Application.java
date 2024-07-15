package com.example.salhumanbe6;

import com.example.salhumanbe6.dtos.congeDTO;
import com.example.salhumanbe6.dtos.employeDTO;
import com.example.salhumanbe6.entities.*;
import com.example.salhumanbe6.enums.TypeE;
import com.example.salhumanbe6.mappers.transf;
import com.example.salhumanbe6.repositories.CongeRepository;
import com.example.salhumanbe6.repositories.ElementSalaireRepository;
import com.example.salhumanbe6.repositories.EmployeRepository;
import com.example.salhumanbe6.repositories.FicheDePaieRepository;
import com.example.salhumanbe6.services.CongeService;
import com.example.salhumanbe6.services.EmployeService;
import com.example.salhumanbe6.services.FicheDePaieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SalHumanBe6Application {

    public static void main(String[] args) {
        SpringApplication.run(SalHumanBe6Application.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(EmployeService employeService, CongeService congeService, ElementSalaireRepository elementSalaireRepository, FicheDePaieRepository ficheDePaieRepository){
        return args -> {
            Stream.of("Hassan","Imane","Zineb","Ismail","Nissrine").forEach(name -> {
                Employe employe = new Employe();
                employe.setNom(name);
                employe.setPrenom("Omari");
                employe.setDate_embauche(new Date());
                if (name.equals("Samir") ||name.equals("Imane") ||name.equals("Zineb")) {
                    employe.setPoste("Ingénieure");
                    employe.setDepartement("Informatique");
                }
                else {
                    employe.setPoste("Comptable");
                    employe.setDepartement("Finance");
                }

                employeDTO dto = new transf().fromEmploye(employe);
                employeService.createEmploye(dto);
            });

            employeService.getAllEmploye().forEach(employe -> {
                for (int i=0;i<=2;i++){
                Conge conge = new Conge();
                conge.setDateDebut(new Date());
                conge.setDateFin(new Date());
                if (employe.getNom().equals("Hassan")|| employe.getNom().equals("Imane")) {
                    conge.setStatut("en cours");
                    conge.setTypeDeConge("maladie");
                }
                else {
                    conge.setStatut("fin");
                    conge.setTypeDeConge("Familiale");
                }
                Employe Employe = new transf().fromEmployeDTO(employe);
                conge.setEmploye(Employe);
                congeDTO dto = new transf().fromConge(conge);
                congeService.createConge(dto);}
                FicheDePaie ficheDePaie = new FicheDePaie();
                ficheDePaie.setPeriode("2024-06");
                ficheDePaie.setMontant_net(Math.random()+15000);
                ficheDePaie.setMontant_brut(Math.random()+10000);
                ficheDePaie.setDetails_deductions(5);
                ficheDePaie.setEmploye(new transf().fromEmployeDTO(employe));
                ficheDePaieRepository.save(ficheDePaie);

                ElementSalaire salaireBase = new ElementSalaire();
                salaireBase.setMontant(Math.random());
                salaireBase.setTypeE(TypeE.base);
                salaireBase.setFicheDePaie(ficheDePaie);

                ElementSalaire prime = new ElementSalaire();
                if (employe.getIdEmploye()!=1||employe.getIdEmploye()!=2)
                    prime.setMontant(Math.random()+10000);
                {prime.setTypeE(TypeE.prime);
                prime.setFicheDePaie(ficheDePaie);}
                    prime.setMontant(Math.random()+10000);
                    prime.setTypeE(TypeE.base);
                        prime.setFicheDePaie(ficheDePaie);

                elementSalaireRepository.save(salaireBase);
                elementSalaireRepository.save(prime);
            });
        };};}


