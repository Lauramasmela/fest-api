package com.sofia.festapi.repository;

import com.sofia.festapi.domain.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, String> {

    Optional<Commune> findFirstByNomCommuneAndCodePostal(String nomCommune, String codePostal);

}
