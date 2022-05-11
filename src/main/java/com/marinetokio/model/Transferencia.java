package com.marinetokio.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;


@Data
public class Transferencia {

	@Id
	private Long id;
	@Column(length = 6)
	private Long contaOrigem;
	@Column(length = 6)
	private Long contaDestino;
	private Long valor;
	private Long dataTransferencia;
	private Long dataAgendada;
	private String tipoOperacao;
	
}
