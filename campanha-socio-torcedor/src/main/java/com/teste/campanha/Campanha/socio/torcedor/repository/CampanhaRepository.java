package com.teste.campanha.Campanha.socio.torcedor.repository;

import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanhaRepository  extends JpaRepository<Campanha, Integer> {
    Campanha findCampanhaById(Integer id);
}
