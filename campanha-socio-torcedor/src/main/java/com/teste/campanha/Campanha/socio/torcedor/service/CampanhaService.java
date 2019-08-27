package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.config.ModelMapperConfig;
import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.CampanhaException;
import com.teste.campanha.Campanha.socio.torcedor.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CampanhaService {
    @Autowired
    private ModelMapperConfig modelMapper;

    @Autowired
    private CampanhaRepository campanhaRepository;

    public List<Campanha> findCampanhasByVigencia() {
        List<Campanha> campanhas = campanhaRepository.findAll();
        return campanhas;
    }

    @Transactional
    public Campanha save(final CampanhaDTO campanhaDTO) {
        final Campanha campanha = modelMapper.modelMapper().map(campanhaDTO, Campanha.class);
        return campanhaRepository.save(campanha);
    }

    @Transactional
    public Campanha update(CampanhaDTO campanhaDTO) {
        Campanha campanha = modelMapper.modelMapper().map(campanhaDTO, Campanha.class);
        Campanha campanhaResponse = null;
        if (Objects.nonNull(campanha)) {
            campanhaResponse = campanhaRepository.save(campanha);
        }
        return campanhaResponse;
    }

    @Transactional
    public void delete(final Integer id) throws CampanhaException {
        Campanha campanha = Optional.ofNullable(campanhaRepository.findCampanhaById(id)).orElseThrow(() -> new CampanhaException());
        this.campanhaRepository.delete(campanha);
    }

    public Campanha findCampanhaById(final Integer id) {
        return campanhaRepository.findCampanhaById(id);
    }
}
