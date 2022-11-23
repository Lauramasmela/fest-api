package com.sofia.festapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categorie {
    @Id
    @Column(name = "categorie_id")
    private String id;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "categorie_fest",
            joinColumns = @JoinColumn(name = "fest_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Fest> fests;
}
