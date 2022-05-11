package com.marinetokio.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.marinetokio.dto.TransferenciaDto;
import com.marinetokio.model.Transferencia;
import com.marinetokio.repository.TransferenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransferenciaService {
	
	TransferenciaRepository transferenciaRepository;
	
	//private static final Logger logger = LogManager.getLogger(Transferencia.class);

	private static final ModelMapper modelMapper = new ModelMapper();
	
	public void calculoTaxa(Transferencia transferencia) {
		TransferenciaDto transferenciaDto = modelMapper.map(transferencia, TransferenciaDto.class);
		transferencia = transferenciaRepository.getById(transferenciaDto.getId());
		if(transferencia.getTipoOperacao() == "A") {
			if(transferencia.getDataAgendada() == transferencia.getDataTransferencia()){
				transferencia.setTaxa((transferencia.getValor() * 0.03) + 3.00);
			}
		}
	}
	
}
