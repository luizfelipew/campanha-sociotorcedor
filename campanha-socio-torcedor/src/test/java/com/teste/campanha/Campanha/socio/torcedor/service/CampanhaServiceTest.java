package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import com.teste.campanha.Campanha.socio.torcedor.dto.CampanhaDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.CampanhaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampanhaServiceTest{

    @Mock
    private CampanhaService campanhaService;

//    @Before
//    public void setUp() {
////        this.mockMvc = MockMvcBuilders.standaloneSetup(campanhaService).build();
//    }

    @Test
    public void shouldReturnCampanha(){
        List<Campanha> campanhas = campanhaService.findCampanhasByVigencia();
        System.out.println(campanhas);
    }

    @Test
    public void shouldSaveCampanha(){
        campanhaService.save(new CampanhaDTO("CampanhaTest", 1, LocalDate.now(), LocalDate.now()));
    }

    @Test
    public void shouldUpdateCampanha() {
        campanhaService.update(new CampanhaDTO("CampanhaTest", 1, LocalDate.now(), LocalDate.now()));
    }

    @Test
    public void shoudCampanhaById() {
        final Integer id = 1;
        campanhaService.findCampanhaById(id);
    }

    @Test
    public void shouldDeleteCamapanhaById() throws CampanhaException {
        final Integer id = 1;
        campanhaService.delete(id);
    }

}
