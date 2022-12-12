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
        createCommuneIfNotExists(newFest);
        festRepository.save(newFest);
    }

    private void createCommuneIfNotExists(Fest fest) {
        var commune = communeService.getCommune(fest.getCommune());
        if(commune == null){
            commune = communeService.createCommune(fest.getCommune());
        }
        fest.setCommune(commune);
    }

    public void updateFest(String festId, FestDTO festDTO) throws FestAPIException {
       var festFromDB = getFestById(festId);
       var modifiedFest = festConverter.convertDTOToEntity(festDTO);
           festFromDB.setNomFest(modifiedFest.getNomFest());

        festFromDB.setDescription(modifiedFest.getDescription());
        festFromDB.setSiteWeb(modifiedFest.getSiteWeb());
        festFromDB.setMoisHabituelDebut(modifiedFest.getMoisHabituelDebut());
        festFromDB.setDateDebut(modifiedFest.getDateDebut());
        festFromDB.setDateFin(modifiedFest.getDateFin());
        createCommuneIfNotExists(modifiedFest);
        festFromDB.setCommune(modifiedFest.getCommune());
        festFromDB.setPeriodicite(modifiedFest.getPeriodicite());
        festRepository.save(festFromDB);
    }

    public void deleteFest(String festId) throws FestAPIException{
        var festFromDB = getFestById(festId);
        festRepository.delete(festFromDB);
    }






}
