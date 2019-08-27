package com.teste.campanha.Campanha.socio.torcedor.controller;

import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.TimeCoracaoDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.ListaSociosTorcedoresException;
import com.teste.campanha.Campanha.socio.torcedor.exception.ListaTimeCoracaoException;
import com.teste.campanha.Campanha.socio.torcedor.exception.SocioTorcedorException;
import com.teste.campanha.Campanha.socio.torcedor.exception.TimeCoracaoException;
import com.teste.campanha.Campanha.socio.torcedor.facade.SocioTorcedorFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "v1/time_coracao")
public class TimeCoracaoController {
    @Autowired
    private SocioTorcedorFacade socioTorcedorFacade;

    @ApiOperation(value = "Lista de time de coracao", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<TimeCoracaoDTO> listaTimesCoracao() throws ListaTimeCoracaoException {
        return this.socioTorcedorFacade.listaTimeCoracao();
    }

    @ApiOperation(value = "Cria um time de coracao", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/salvar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public TimeCoracaoDTO criarTimeCoracao(@RequestBody @Valid TimeCoracaoDTO timeCoracaoDTO) {
        return this.socioTorcedorFacade.criaTimeCoracao(timeCoracaoDTO);
    }

    @ApiOperation(value = "Busca um time de coracao", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/buscar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public TimeCoracaoDTO buscaTimeCoracao(@PathVariable("id") @Valid Integer id) throws TimeCoracaoException {
        return this.socioTorcedorFacade.buscaTimeCoracao(id);
    }

    @ApiOperation(value = "Atualiza um time de coracao", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/atualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public TimeCoracaoDTO atualizaTimeCoracao(@RequestBody @Valid TimeCoracaoDTO timeCoracaoDTO) {
        return this.socioTorcedorFacade.alteraTimeCoracao(timeCoracaoDTO);
    }

    @ApiOperation(value = "Deleta um time de coracao", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "/deletar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deletarTimeCoracao(@PathVariable("id") @Valid Integer id) throws TimeCoracaoException {
        this.socioTorcedorFacade.excluirTimeCoracao(id);
    }
}
