package com.teste.campanha.Campanha.socio.torcedor.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TIME_CORACAO")
public class TimeCoracao implements Serializable {

    private static final long serialVersionUID = 7220822188282864343L;

    @Id
    @Column(name = "TIME_CORACAO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Nome do time obrigatorio")
    @Column(name = "NOME_TIME")
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

    public void setNomeTime(String nomeSocio) {
        this.nomeTime = nomeTime;
    }
}
