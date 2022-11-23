package com.sofia.festapi.dto;

import lombok.Data;

@Data
public class CommuneDTO {
    private String id;

    private String nomCommune;

    private String codePostal;

    private String codeDepartement;

    private String nomDepartement;

    private String nomRegion;

    //private List<Fest> festsList;
}
