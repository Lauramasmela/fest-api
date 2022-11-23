package com.sofia.festapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FestDTO {

    private String id;

    private String nomFest;
    private String description;

    private String siteWeb;

    private String moisHabituelDebut;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private LocalDate dateCreation;
    private double latitude;
    private double longitude;

    private CommuneDTO communeDTO;
    private String periodicite;

    //private List<Categorie> categories;
}
