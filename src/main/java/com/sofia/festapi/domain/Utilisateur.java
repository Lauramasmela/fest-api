package com.sofia.festapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Utilisateur {
    @Id
    @Column(name = "utilisateur_id")
    private String id;
    private String prenom;
    private String nom;
    private String role;
    private String email;
    private String password;
    private String adresse;
    @Column(name = "ville_residence")
    private String villeResidence;
    @Column(name = "code_postal_residence")
    private String codePostalResidence;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
}
