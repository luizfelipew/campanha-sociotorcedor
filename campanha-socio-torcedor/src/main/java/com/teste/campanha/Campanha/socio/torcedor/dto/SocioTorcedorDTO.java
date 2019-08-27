package com.teste.campanha.Campanha.socio.torcedor.dto;

import com.teste.campanha.Campanha.socio.torcedor.domain.SocioTorcedor;
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
public class SocioTorcedorDTO implements Serializable {

    private static final long serialVersionUID = 5147478756347912393L;

    @NotNull(message = "Nome socio obrigatorio")
    private String nomeSocio;

    @NotNull(message = "Data de nascimento obrigatoria")
    private LocalDate dataNascimento;

    @NotNull(message = "Time de coracao obrigatorio")
    private String timeCoracao;

    @NotNull(message = "Email obrigatorio")
    private String email;

    public SocioTorcedorDTO(String nomeSocio, LocalDate dataNascimento,  String timeCoracao,  String email) {
        this.nomeSocio = nomeSocio;
        this.dataNascimento = dataNascimento;
        this.timeCoracao = timeCoracao;
        this.email = email;
    }

    public SocioTorcedorDTO(SocioTorcedor socioTorcedor) {
        nomeSocio = socioTorcedor.getNomeSocio();
        dataNascimento = socioTorcedor.getDataNascimento();
        timeCoracao = socioTorcedor.getTimeCoracao();
        email = socioTorcedor.getEmail();
    }


    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTimeCoracao() {
        return timeCoracao;
    }

    public void setTimeCoracao(String timeCoracao) {
        this.timeCoracao = timeCoracao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
