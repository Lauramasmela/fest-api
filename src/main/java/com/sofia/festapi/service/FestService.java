package com.sofia.festapi.service;

import com.sofia.festapi.converter.FestConverter;
import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.domain.Fest;
import com.sofia.festapi.dto.FestDTO;
import com.sofia.festapi.exception.FestAPIException;
import com.sofia.festapi.repository.CommuneRepository;
import com.sofia.festapi.repository.FestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FestService {
    private FestConverter festConverter;
    private FestRepository festRepository;
    private CommuneService communeService;

    private Fest getFestById(String festId) throws FestAPIException {
        return festRepository.findById(festId).orElseThrow(() -> new FestAPIException("Cet id n'existe pas"));
    }

    public FestDTO getFestDTOById(String festId) throws FestAPIException {
        return festConverter.convertEntityToDTO(getFestById(festId));
    }

    public void addNewFest(FestDTO festDTO){
        var newFest = festConverter.convertDTOToEntity(festDTO);
        newFest.setId(UUID.randomUUID().toString().replace("-", ""));
        var commune = communeService.getCommune(newFest.getCommune());
        if(commune != null){
            newFest.setCommune(commune);
        }else{
            communeService.createCommune(newFest.getCommune());
        }
        festRepository.save(newFest);
    }





}
