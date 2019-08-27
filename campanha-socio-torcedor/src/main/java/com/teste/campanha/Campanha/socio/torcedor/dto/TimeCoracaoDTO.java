package com.teste.campanha.Campanha.socio.torcedor.dto;

import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
import com.teste.campanha.Campanha.socio.torcedor.domain.TimeCoracao;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TimeCoracaoDTO implements Serializable {

    private static final long serialVersionUID = 6839986391951690854L;

    private Integer id;

    @NotNull(message = "Nome do time obrigatorio")
    private String nomeTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public TimeCoracaoDTO(Integer id, String nomeTime) {
        this.id = id;
        this.nomeTime = nomeTime;
    }

    public TimeCoracaoDTO(final TimeCoracao timeCoracao) {
        id = timeCoracao.getId();
        nomeTime = timeCoracao.getNomeTime();
    }
}
