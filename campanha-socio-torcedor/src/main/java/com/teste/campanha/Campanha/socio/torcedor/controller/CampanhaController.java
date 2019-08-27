package com.teste.campanha.Campanha.socio.torcedor.controller;

import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.CampanhaException;
import com.teste.campanha.Campanha.socio.torcedor.exception.ListaCampanhasException;
import com.teste.campanha.Campanha.socio.torcedor.facade.SocioTorcedorFacade;
import com.teste.campanha.Campanha.socio.torcedor.service.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "v1/campanha")
public class CampanhaController {

    @Autowired
    private SocioTorcedorFacade socioTorcedorFacade;

    @Autowired
    private CampanhaService campanhaService;

    @ApiOperation(value = "Lista campanhas", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<CampanhaDTO> listaCampanhas() throws ListaCampanhasException {
        return this.socioTorcedorFacade.listaCampanhas();
    }

    @ApiOperation(value = "Cria uma Campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CampanhaDTO criarCampanha(@RequestBody @Valid CampanhaDTO campanhaDTO) {
        return this.socioTorcedorFacade.criaCampanha(campanhaDTO);
    }

    @ApiOperation(value = "Busca uma Campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/buscar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CampanhaDTO buscaCampanha(@PathVariable("id") @Valid Integer id) throws CampanhaException {
        return this.socioTorcedorFacade.buscaCampanha(id);
    }

    @ApiOperation(value = "Atualiza uma Campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/atualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CampanhaDTO atualizaCampanha(@RequestBody @Valid CampanhaDTO campanhaDTO) {
        return this.socioTorcedorFacade.alteraCampanha(campanhaDTO);
    }

    @ApiOperation(value = "Deleta uma Campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "/deletar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deletarCampanha(@PathVariable("id") @Valid Integer id) throws CampanhaException {
        this.socioTorcedorFacade.excluirCampanha(id);
    }

}
