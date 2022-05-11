package com.marinetokio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.marinetokio.DTO.TransferenciaDTO;
import com.marinetokio.dto.TransferenciaDto;
import com.marinetokio.model.Transferencia;
import com.marinetokio.repository.TransferenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransferenciaService {
	
	TransferenciaRepository transferenciaRepository;

	private static final ModelMapper modelMapper = new ModelMapper();
	
	public void calculoTaxa(Transferencia transferencia) {
		TransferenciaDto transferenciaDto = modelMapper.map(transferencia, TransferenciaDto.class);
		transferencia = transferenciaRepository.getById(transferenciaDto.getId());
		Long periodo = transferencia.getDataTransferencia() - transferencia.getDataAgendada();
		if(transferencia.getTipoOperacao() == "A") {
			if(transferencia.getDataAgendada() == transferencia.getDataTransferencia()){
				transferencia.setTaxa((transferencia.getValor() * 0.03) + 3.00);
			}else {
				System.out.println("Data inválida, precisa ser a mesma de hoje");
			}
		}
		if(transferencia.getTipoOperacao() == "B") {
			if(periodo <= 10) {
				transferencia.setTaxa(12.00);
			}else {
				System.out.println("Data inválida, a transferência deve ser agendada"
						+ "para até 10 dias.");
			}
		}
		if(transferencia.getTipoOperacao() == "C") {
			if(periodo != 0 && periodo > 10 && periodo <= 20) {
				transferencia.setTaxa(transferencia.getValor() * 0.082);
			}else if(periodo > 20 && periodo <= 30){
				transferencia.setTaxa(transferencia.getValor() * 0.069);
			}else if(periodo > 30 && periodo <= 40) {
				transferencia.setTaxa(transferencia.getValor() * 0.047);
			}else if(periodo > 40){
				transferencia.setTaxa(transferencia.getValor() * 0.017);
			}else {
				System.out.println("Erro: Taxa não aplicável");
			}
		}
		if(transferencia.getTipoOperacao() == "D") {
			if(transferencia.getValor() <= 1000.00) {
				transferencia.setTaxa((transferencia.getValor() * 0.03) + 3.00);
			}
			if(transferencia.getValor() > 1000.00 && transferencia.getValor() <= 2000.00) {
				transferencia.setTaxa(12.00);
			}
			if(transferencia.getValor() > 2000.00) {
				if(periodo != 0 && periodo > 10 && periodo <= 20) {
					transferencia.setTaxa(transferencia.getValor() * 0.082);
				}else if(periodo > 20 && periodo <= 30){
					transferencia.setTaxa(transferencia.getValor() * 0.069);
				}else if(periodo > 30 && periodo <= 40) {
					transferencia.setTaxa(transferencia.getValor() * 0.047);
				}else if(periodo > 40){
					transferencia.setTaxa(transferencia.getValor() * 0.017);
				}else {
					System.out.println("Erro: Taxa não aplicável");
				}
			}
		}
	}
	
	public List<TransferenciaDto> listar() {
		List<Transferencia> transferencia = transferenciaRepository.findAll();
		return new ArrayList<>(transferencia.stream()
				.map(transfer -> new ModelMapper().map(transfer, TransferenciaDto.class)).collect(Collectors.toList()));
	}
	
}
