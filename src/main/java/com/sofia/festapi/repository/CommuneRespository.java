package com.sofia.festapi.repository;

import com.sofia.festapi.domain.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRespository extends JpaRepository<Commune, String> {
}
