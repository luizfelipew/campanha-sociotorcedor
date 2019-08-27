package com.teste.campanha.Campanha.socio.torcedor.domain;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
@Entity
@Table(name = "CAMPANHA_SOCIO")
public class CampanhaSocioPK implements Serializable {

    private static final long serialVersionUID = 5219584381144441146L;

    @ManyToMany
    @JoinColumn(name = "CAMPANHA_ID")
    private Campanha campanha;

    @ManyToMany
    @JoinColumn(name = "SOCIO_ID")
    private SocioTorcedor socioTorcedor;

}
