package com.teste.campanha.Campanha.socio.torcedor.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SOCIO_TORCEDOR")
public class SocioTorcedor implements Serializable {

    private static final long serialVersionUID = 7444927278272766097L;

    @Id
    @Column(name = "SOCIO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Nome socio obrigatorio")
    @Column(name = "NOME_SOCIO")
    private String nomeSocio;

    @NotNull(message = "Data de nascimento obrigatoria")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @NotNull(message = "Time de coracao obrigatorio")
    @Column(name = "TIME_CORACAO")
    private String timeCoracao;

    @NotNull(message = "Email obrigatorio")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTIVE_STATUS")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "CAMPANHA_ID")
    private Campanha campanha;

    public SocioTorcedor(Integer id, @NotNull(message = "Nome socio obrigatorio") String nomeSocio, @NotNull(message = "Data de nascimento obrigatoria") LocalDate dataNascimento, @NotNull(message = "Time de coracao obrigatorio") String timeCoracao, @NotNull(message = "Email obrigatorio") String email, boolean active, Campanha campanha) {
        this.id = id;
        this.nomeSocio = nomeSocio;
        this.dataNascimento = dataNascimento;
        this.timeCoracao = timeCoracao;
        this.email = email;
        this.active = active;
        this.campanha = campanha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }
}
