package com.sofia.festapi.repository;

import com.sofia.festapi.domain.Fest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestRepository extends JpaRepository<Fest, String> {
}
