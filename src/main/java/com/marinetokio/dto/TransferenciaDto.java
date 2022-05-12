package com.marinetokio.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TransferenciaDTO {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 6)
	private Long contaOrigem;
	@Column(length = 6)
	private Long contaDestino;
	private Double valor;
	private Double taxa;
	private Long dataTransferencia;
	private Long dataAgendada;
	private String tipoOperacao;
}
