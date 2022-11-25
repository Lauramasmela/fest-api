package com.sofia.festapi.converter;

import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.dto.CommuneDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommuneConverter {
    public CommuneDTO converterEntityToDTO(Commune commune) {
        var modelMapper = new ModelMapper();
        var communeDTO = modelMapper.map(commune, CommuneDTO.class);
        return communeDTO;
    }

    public Commune converterDTOToEntity(CommuneDTO communeDTO) {
        var modelMapper = new ModelMapper();
        var commune = modelMapper.map(communeDTO, Commune.class);
        commune.setId(UUID.randomUUID().toString());
        return commune;


    }
}