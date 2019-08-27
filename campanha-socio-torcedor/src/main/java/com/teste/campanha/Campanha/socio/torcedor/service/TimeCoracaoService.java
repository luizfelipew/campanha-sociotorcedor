package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.config.ModelMapperConfig;
import com.teste.campanha.Campanha.socio.torcedor.domain.TimeCoracao;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.TimeCoracaoDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.TimeCoracaoException;
import com.teste.campanha.Campanha.socio.torcedor.repository.TimeCoracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TimeCoracaoService {

    @Autowired
    private ModelMapperConfig modelMapper;

    @Autowired
    private TimeCoracaoRepository timeCoracaoRepository;

    public List<TimeCoracao> listTimeCoracao() {
        return this.timeCoracaoRepository.findAll();
    }

    @Transactional
    public TimeCoracao save(final TimeCoracaoDTO timeCoracaoDTO) {
        final TimeCoracao timeCoracao = modelMapper.modelMapper().map(timeCoracaoDTO, TimeCoracao.class);
        return this.timeCoracaoRepository.save(timeCoracao);
    }

    @Transactional
    public TimeCoracao update(final TimeCoracaoDTO timeCoracaoDTO) {
        final TimeCoracao timeCoracao = modelMapper.modelMapper().map(timeCoracaoDTO, TimeCoracao.class);
        TimeCoracao timeCoracaoResponse = null;
        if (Objects.nonNull(timeCoracao)) {
            timeCoracaoResponse = this.timeCoracaoRepository.save(timeCoracao);
        }
        return timeCoracaoResponse;
    }

    public TimeCoracao findTimeCoracaoById(Integer id) {
        return this.timeCoracaoRepository.findTimeCoracaoById(id);
    }

    public void delete(final Integer id) throws TimeCoracaoException {
        final TimeCoracao timeCoracao = Optional.ofNullable(this.timeCoracaoRepository.findTimeCoracaoById(id)).orElseThrow(() -> new TimeCoracaoException());
        timeCoracaoRepository.delete(timeCoracao);
    }
}
