package com.teste.campanha.Campanha.socio.torcedor.repository;

import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioTorcedorRepository extends JpaRepository<SocioTorcedor, Integer> {
    SocioTorcedor findSocioById(final Integer id);
    SocioTorcedor findByEmail(final String email);
}
