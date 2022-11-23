package com.sofia.festapi.converter;

import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.dto.CommuneDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommuneConverter {
    public CommuneDTO converterEntityToDTO(Commune commune){
        var modelMapper = new ModelMapper();
        var communeDTO = modelMapper.map(commune, CommuneDTO.class);
        return communeDTO;
    }
}
