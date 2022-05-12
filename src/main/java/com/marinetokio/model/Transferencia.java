package com.marinetokio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 6)
	private String contaOrigem;
	
	@Column(length = 6)
	private String contaDestino;
	
	private Double valor;
	private Double taxa;
	private Long dataTransferencia;
	private Long dataAgendada;
	private Long tipoOperacao;
	
}
