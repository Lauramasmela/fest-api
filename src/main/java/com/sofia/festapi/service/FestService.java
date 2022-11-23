package com.sofia.festapi.service;

import com.sofia.festapi.converter.FestConverter;
import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.domain.Fest;
import com.sofia.festapi.dto.FestDTO;
import com.sofia.festapi.exception.FestAPIException;
import com.sofia.festapi.repository.FestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FestService {
    private FestConverter festConverter;
    private FestRepository festRepository;

    private Fest getFestById(String festId) throws FestAPIException {
        return festRepository.findById(festId).orElseThrow(() -> new FestAPIException("Cet id n'existe pas"));
    }

    public FestDTO getFestDTOById(String festId) throws FestAPIException {
        return festConverter.convertEntityToDTO(getFestById(festId));
    }



}
