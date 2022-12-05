package com.sofia.festapi.service;

import com.sofia.festapi.domain.Commune;
import com.sofia.festapi.repository.CommuneRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommuneService {
   private CommuneRepository communeRepository;

   @Nullable
   public Commune getCommune(Commune commune) {
      return communeRepository.findFirstByNomCommuneAndCodePostal(commune.getNomCommune(), commune.getCodePostal()).orElse(null);

   }

   public Commune createCommune(Commune commune){
      return communeRepository.save(commune);
   }

}
