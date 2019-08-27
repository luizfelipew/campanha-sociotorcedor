package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.config.ModelMapperConfig;
import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
import com.teste.campanha.Campanha.socio.torcedor.domain.TimeCoracao;
import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.CampanhaException;
import com.teste.campanha.Campanha.socio.torcedor.exception.EmailException;
import com.teste.campanha.Campanha.socio.torcedor.exception.SocioTorcedorException;
import com.teste.campanha.Campanha.socio.torcedor.repository.CampanhaRepository;
import com.teste.campanha.Campanha.socio.torcedor.repository.SocioTorcedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SocioTorcedorService {
    @Autowired
    private ModelMapperConfig modelMapper;

    @Autowired
    private SocioTorcedorRepository socioTorcedorRepository;

    public SocioTorcedorService(final SocioTorcedorRepository socioTorcedorRepository) {
        this.socioTorcedorRepository = socioTorcedorRepository;
    }


    public List<SocioTorcedor> findSocioTorcedor() {
        return socioTorcedorRepository.findAll();
    }

    @Transactional
    public SocioTorcedor save(final SocioTorcedorDTO socioTorcedorDTO) throws EmailException {
        final SocioTorcedor socioTorcedor = modelMapper.modelMapper().map(socioTorcedorDTO, SocioTorcedor.class);
        if (this.verificaEmail(socioTorcedor.getEmail())) throw new EmailException();
        return socioTorcedorRepository.save(socioTorcedor);
    }

    @Transactional
    public SocioTorcedor update(final SocioTorcedorDTO socioTorcedorDTO) {
        final SocioTorcedor socioTorcedor = modelMapper.modelMapper().map(socioTorcedorDTO, SocioTorcedor.class);
        SocioTorcedor socioTorcedorResponse = null;
        if (Objects.nonNull(socioTorcedor)){
            socioTorcedorResponse = socioTorcedorRepository.save(socioTorcedor);
        }
        return socioTorcedorResponse;
    }

    @Transactional
    public void delete(final Integer id) throws SocioTorcedorException {
        final SocioTorcedor socioTorcedor = Optional.ofNullable(socioTorcedorRepository.findSocioById(id)).orElseThrow(() -> new SocioTorcedorException());
        this.socioTorcedorRepository.delete(socioTorcedor);
    }

    public SocioTorcedor findSocioTorcedorById(final Integer id) {
        return socioTorcedorRepository.findSocioById(id);
    }

    protected boolean verificaEmail(final String email) {
        SocioTorcedor socio = this.socioTorcedorRepository.findByEmail(email);
        return socio != null;
    }

}
