package com.sofia.festapi.converter;

import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.dto.CommuneDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component
public class CommuneConverter {
    public CommuneDTO converterEntityToDTO(Commune commune) {
        var modelMapper = new ModelMapper();
        var communeDTO = modelMapper.map(commune, CommuneDTO.class);
        return communeDTO;
    }

    public Commune converterDTOToEntity(CommuneDTO communeDTO) {
        Commune commune = null;
        if(communeDTO != null){
            var modelMapper = new ModelMapper();
            commune = modelMapper.map(communeDTO, Commune.class);
            commune.setId(UUID.randomUUID().toString());
            commune.setNomCommune(communeDTO.getNomCommune().toUpperCase());
            String nomRegion = communeDTO.getNomRegion();
            String motsNomRegion[] = nomRegion.split("[-\\s]");
            String capitalStrRegion = "";
            for(String mot : motsNomRegion){
                if(mot.length() > 2){
                    String premiereLettre = mot.substring(0, 1);
                    String lettreSuivante = mot.substring(1);
                    capitalStrRegion+=premiereLettre.toUpperCase()+lettreSuivante;
                }
            }
            commune.setNomRegion(capitalStrRegion);

            String nomDepartement = communeDTO.getNomDepartement();
            String motsNomDepartement[]= nomDepartement.split("[-\\s]");
            String capitalStrDepartement = "";
            for (String mot : motsNomDepartement){
                if(mot.length() > 2){
                    String premiereLettre = mot.substring(0,1);
                    String lettreSuivante=mot.substring(1);
                    capitalStrDepartement+=premiereLettre.toUpperCase()+lettreSuivante;
                }
            }
            commune.setNomDepartement(capitalStrDepartement);
        }

        return commune;
    }
}