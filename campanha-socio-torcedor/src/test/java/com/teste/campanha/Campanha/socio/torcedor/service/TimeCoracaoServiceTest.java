package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
import com.teste.campanha.Campanha.socio.torcedor.domain.TimeCoracao;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.dto.TimeCoracaoDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.SocioTorcedorException;
import com.teste.campanha.Campanha.socio.torcedor.exception.TimeCoracaoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeCoracaoServiceTest {

    @Mock
    private TimeCoracaoService timeCoracaoService;

    @Test
    public void shouldReturnTimeCoracao(){
        List<TimeCoracao> timeCoracaoList = timeCoracaoService.listTimeCoracao();
        System.out.println(timeCoracaoList);
    }

    @Test
    public void shouldSaveTimeCoracao(){
        timeCoracaoService.save(new TimeCoracaoDTO( 1,"Sao Paulo" ));
    }

    @Test
    public void shouldUpdateTimeCoracao() {
        timeCoracaoService.update(new TimeCoracaoDTO(1, "Sao Paulo juniores"));
    }

    @Test
    public void shoudSocioTimeCoracaoById() {
        final Integer id = 1;
        timeCoracaoService.findTimeCoracaoById(id);
    }

    @Test
    public void shouldDeleteTimeCoracaoById() throws TimeCoracaoException {
        final Integer id = 1;
        timeCoracaoService.delete(id);
    }

}
