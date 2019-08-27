package com.teste.campanha.Campanha.socio.torcedor.facade;

import com.teste.campanha.Campanha.socio.torcedor.config.ModelMapperConfig;
import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.TimeCoracaoDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.*;
import com.teste.campanha.Campanha.socio.torcedor.service.CampanhaService;
import com.teste.campanha.Campanha.socio.torcedor.service.SocioTorcedorService;
import com.teste.campanha.Campanha.socio.torcedor.service.TimeCoracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SocioTorcedorFacade {

    @Autowired
    private CampanhaService campanhaService;

    @Autowired
    private SocioTorcedorService socioTorcedorService;

    @Autowired
    private TimeCoracaoService timeCoracaoService;

    @Autowired
    private ModelMapperConfig mapper;

    public CampanhaDTO buscaCampanha(final Integer id) throws CampanhaException {
        return Optional.ofNullable(campanhaService.findCampanhaById(id))
                .map(CampanhaDTO::new).orElseThrow(() -> new CampanhaException());
    }

    public CampanhaDTO criaCampanha(final CampanhaDTO campanhaDTO) {
        return mapper.modelMapper().map(campanhaService.save(campanhaDTO), CampanhaDTO.class);
    }

    public List<CampanhaDTO> listaCampanhas() throws ListaCampanhasException {
        return campanhaService.findCampanhasByVigencia().stream()
                .map(CampanhaDTO::new)
                .collect(Collectors.toList());
    }

    public CampanhaDTO alteraCampanha(final CampanhaDTO campanhaDTO) {
        return mapper.modelMapper().map(campanhaService.update(campanhaDTO), CampanhaDTO.class);
    }

    public void excluirCampanha(final Integer id) throws CampanhaException {
        this.campanhaService.delete(id);
    }

    public SocioTorcedorDTO buscaSocioTorcedor(final Integer id) throws SocioTorcedorException {
        return Optional.ofNullable(socioTorcedorService.findSocioTorcedorById(id))
                .map(SocioTorcedorDTO::new).orElseThrow(() -> new SocioTorcedorException());
    }

    public SocioTorcedorDTO criaSocioTorcedor(final SocioTorcedorDTO socioTorcedorDTO) throws EmailException {
        return mapper.modelMapper().map(socioTorcedorService.save(socioTorcedorDTO), SocioTorcedorDTO.class);
    }

    public List<SocioTorcedorDTO> listaSocioTorcedores() throws ListaSociosTorcedoresException {
        return socioTorcedorService.findSocioTorcedor().stream()
                .map(SocioTorcedorDTO::new)
                .collect(Collectors.toList());
    }

    public SocioTorcedorDTO alteraSocioTorcedor(final SocioTorcedorDTO socioTorcedorDTO) {
        return mapper.modelMapper().map(socioTorcedorService.update(socioTorcedorDTO), SocioTorcedorDTO.class);
    }

    public void excluirSocioTorcedor(final Integer id) throws SocioTorcedorException {
        this.socioTorcedorService.delete(id);
    }

    public TimeCoracaoDTO buscaTimeCoracao(final Integer id) throws TimeCoracaoException {
        return Optional.ofNullable(timeCoracaoService.findTimeCoracaoById(id))
                .map(TimeCoracaoDTO::new).orElseThrow(() -> new TimeCoracaoException());
    }

    public TimeCoracaoDTO criaTimeCoracao(final TimeCoracaoDTO timeCoracaoDTO) {
        return mapper.modelMapper().map(timeCoracaoService.save(timeCoracaoDTO), TimeCoracaoDTO.class);
    }

    public List<TimeCoracaoDTO> listaTimeCoracao() throws ListaTimeCoracaoException {
        return timeCoracaoService.listTimeCoracao().stream()
                .map(TimeCoracaoDTO::new)
                .collect(Collectors.toList());
    }

    public TimeCoracaoDTO alteraTimeCoracao(final TimeCoracaoDTO timeCoracaoDTO) {
        return mapper.modelMapper().map(timeCoracaoService.update(timeCoracaoDTO), TimeCoracaoDTO.class);
    }

    public void excluirTimeCoracao(final Integer id) throws TimeCoracaoException {
        this.timeCoracaoService.delete(id);
    }
}
