package com.sofia.festapi.converter;

import com.sofia.festapi.domain.Fest;
import com.sofia.festapi.dto.FestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FestConverter {
    private CommuneConverter communeConverter;
    public FestDTO convertEntityToDTO(Fest fest){
        var modelMapper = new ModelMapper();
        var communeDTO = communeConverter.converterEntityToDTO(fest.getCommune());
        var festDTO = modelMapper.map(fest, FestDTO.class);
        festDTO.setCommuneDTO(communeDTO);
        return festDTO;

    }

}
