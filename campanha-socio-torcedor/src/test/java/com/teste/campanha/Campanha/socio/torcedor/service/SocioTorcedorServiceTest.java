package com.teste.campanha.Campanha.socio.torcedor.service;

import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
import com.teste.campanha.Campanha.socio.torcedor.dto.SocioTorcedorDTO;
import com.teste.campanha.Campanha.socio.torcedor.exception.EmailException;
import com.teste.campanha.Campanha.socio.torcedor.exception.SocioTorcedorException;
import com.teste.campanha.Campanha.socio.torcedor.repository.SocioTorcedorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocioTorcedorServiceTest {

    @Mock
    private SocioTorcedorService socioTorcedorService;

    @Mock
    private SocioTorcedorRepository socioTorcedorRepository;

    @Before
    public void setUp() {
        this.socioTorcedorService = new SocioTorcedorService(socioTorcedorRepository);
    }

    @Test
    public void shouldReturnSocioTorcedor(){
        List<SocioTorcedor> socioTorcedors = socioTorcedorService.findSocioTorcedor();
        System.out.println(socioTorcedors);
    }

    @Test
    public void shouldSaveSocioTorcedor() throws EmailException {
        socioTorcedorService.save(new SocioTorcedorDTO("Luiz",  LocalDate.now(), "Sao Paulo", "luizfelipe@test.com"));
    }

    @Test
    public void shouldUpdateSocioTorcedor() {
        socioTorcedorService.update(new SocioTorcedorDTO("Luiz",  LocalDate.now(), "Sao Paulo", "luizfelipe@test.com"));
    }

    @Test
    public void shoudSocioTorcedorById() {
        final Integer id = 1;
        socioTorcedorService.findSocioTorcedorById(id);
    }

    @Test
    public void shouldDeleteSocioTorcedorById() throws SocioTorcedorException {
        final Integer id = 1;
        socioTorcedorService.delete(id);
    }

//    @Test(expected = EmailException.class)
//    public void shouldReturnEmailExcepetion() throws EmailException {
//        when(socioTorcedorService.verificaEmail("teste@email.com")).thenReturn(true);
//        final SocioTorcedorDTO socioTorcedorDTO = null;
//        socioTorcedorDTO.setEmail("teste@email.com");
//        this.socioTorcedorService.save(socioTorcedorDTO);
//    }

}
