package com.marinetokio.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Transferencia {

	@Id
	private Long id;
	private Long contaOrigem;
	private Long contaDestino;
	private Long valor;
	private Long dataTransferencia;
	private Long dataAgendada;
	private String tipoOperacao;
	
}
