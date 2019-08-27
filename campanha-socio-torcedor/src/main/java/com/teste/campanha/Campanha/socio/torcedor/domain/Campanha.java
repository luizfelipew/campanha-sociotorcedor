package com.teste.campanha.Campanha.socio.torcedor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "CAMPANHA")
public class Campanha implements Serializable {

    private static final long serialVersionUID = -6879671937523712593L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_CAMPANHA")
    private String nomeCampanha;

    @Column(name = "TIME_CORACAO_ID")
    private Integer timeCoracaoId;

    @Column(name = "DATA_INICIO")
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "SOCIO_ID")
    private SocioTorcedor socioTorcedor;

    public Campanha(Integer id, String nomeCampanha, Integer timeCoracaoId, LocalDate dataInicio, LocalDate dataFim, SocioTorcedor socioTorcedor) {
        this.id = id;
        this.nomeCampanha = nomeCampanha;
        this.timeCoracaoId = timeCoracaoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.socioTorcedor = socioTorcedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public Integer getTimeCoracaoId() {
        return timeCoracaoId;
    }

    public void setTimeCoracaoId(Integer timeCoracaoId) {
        this.timeCoracaoId = timeCoracaoId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public SocioTorcedor getSocioTorcedor() {
        return socioTorcedor;
    }

    public void setSocioTorcedor(SocioTorcedor socioTorcedor) {
        this.socioTorcedor = socioTorcedor;
    }
}
