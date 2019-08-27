package com.teste.campanha.Campanha.socio.torcedor.controller;

import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.CampanhaException;
import com.teste.campanha.Campanha.socio.torcedor.exception.EmailException;
import com.teste.campanha.Campanha.socio.torcedor.exception.ListaSociosTorcedoresException;
import com.teste.campanha.Campanha.socio.torcedor.exception.SocioTorcedorException;
import com.teste.campanha.Campanha.socio.torcedor.facade.SocioTorcedorFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "v1/socio_torcedor")
public class SocioTorcedorController {
    @Autowired
    private SocioTorcedorFacade socioTorcedorFacade;

    @ApiOperation(value = "Lista de socio torcedores", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<SocioTorcedorDTO> listaSocioTorcedores() throws ListaSociosTorcedoresException {
        return this.socioTorcedorFacade.listaSocioTorcedores();
    }

    @ApiOperation(value = "Cria um Socio Torcedor", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/salvar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public SocioTorcedorDTO criarSocioTorcedor(@RequestBody @Valid SocioTorcedorDTO socioTorcedorDTO) throws EmailException {
        return this.socioTorcedorFacade.criaSocioTorcedor(socioTorcedorDTO);
    }

    @ApiOperation(value = "Busca um socio torcedor", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/buscar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public SocioTorcedorDTO buscaSocioTorcedor(@PathVariable("id") @Valid Integer id) throws SocioTorcedorException {
        return this.socioTorcedorFacade.buscaSocioTorcedor(id);
    }

    @ApiOperation(value = "Atualiza um socio torcedor", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/atualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public SocioTorcedorDTO atualizaSocioTorcedor(@RequestBody @Valid SocioTorcedorDTO socioTorcedorDTO) {
        return this.socioTorcedorFacade.alteraSocioTorcedor(socioTorcedorDTO);
    }

    @ApiOperation(value = "Deleta um socioTorcedor", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "/deletar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deletarSocioTorcedor(@PathVariable("id") @Valid Integer id) throws SocioTorcedorException {
        this.socioTorcedorFacade.excluirSocioTorcedor(id);
    }
}
