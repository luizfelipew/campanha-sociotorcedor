package com.teste.campanha.Campanha.socio.torcedor.repository;

import com.teste.campanha.Campanha.socio.torcedor.domain.TimeCoracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeCoracaoRepository extends JpaRepository<TimeCoracao, Integer> {
    TimeCoracao findTimeCoracaoById(final Integer id);
}
