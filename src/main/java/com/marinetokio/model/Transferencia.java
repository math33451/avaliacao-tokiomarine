package com.marinetokio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Transferencia {

	@Id
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
