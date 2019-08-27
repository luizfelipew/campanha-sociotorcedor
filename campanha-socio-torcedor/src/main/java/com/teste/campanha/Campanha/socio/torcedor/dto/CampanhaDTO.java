package com.teste.campanha.Campanha.socio.torcedor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.campanha.Campanha.socio.torcedor.domain.Campanha;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CampanhaDTO implements Serializable {

	private static final long serialVersionUID = -1897052033187509768L;

	@NotNull(message = "Nome da campanha é obrigatorio")
	private String nomeCampanha;
	
	@NotNull(message = "Id do time de coracao é obrigatorio")
	private Integer timeCoracaoId;
	
	@NotNull(message = "Data de inicio é obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Data de fim é obrigatoria")
	private LocalDate dataFim;



	public CampanhaDTO(String nomeCampanha, Integer timeCoracaoId, LocalDate dataInicio, LocalDate dataFim) {
		this.nomeCampanha = nomeCampanha;
		this.timeCoracaoId = timeCoracaoId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public CampanhaDTO(Campanha campanha) {
		this.nomeCampanha = campanha.getNomeCampanha();
		this.timeCoracaoId = campanha.getTimeCoracaoId();
		this.dataInicio = campanha.getDataInicio();
		this.dataFim = campanha.getDataFim();
	}

}