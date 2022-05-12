package com.marinetokio.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marinetokio.model.Transferencia;
import com.marinetokio.repository.TransferenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransferenciaService {
	
	TransferenciaRepository transferenciaRepository;
	
	private static final Logger logger = LogManager.getLogger(Transferencia.class);

	
	public void calculoTaxa(Transferencia transferencia, Long periodo) {
		periodo = transferencia.getDataTransferencia() - transferencia.getDataAgendada();
		if(transferencia.getTipoOperacao().contains("A")) {
			if(periodo == 0){
				transferencia.setTaxa((transferencia.getValor() * 0.03) + 3.00);
				transferenciaRepository.save(transferencia);
			}else {
				logger.error("A data de transferência é inválida, precisa ser igual ao dia de hoje.");
			}
		}
		if(transferencia.getTipoOperacao().contains("B")){
			if(periodo <= 10 && periodo > 0) {
				transferencia.setTaxa(12.00);
				transferenciaRepository.save(transferencia);
			}else if(periodo == 0) {
				logger.error("A data de transferência é inválida, não pode ser a data de hoje.");
			}else {
				logger.error("A data de transferência é inválida, precisa ser para até 10 dias.");
			}
		}
		if(transferencia.getTipoOperacao().contains("C")) {
			if(periodo != 0 && periodo > 10 && periodo <= 20) {
				transferencia.setTaxa(transferencia.getValor() * 0.082);
				transferenciaRepository.save(transferencia);
			}else if(periodo > 20 && periodo <= 30){
				transferencia.setTaxa(transferencia.getValor() * 0.069);
				transferenciaRepository.save(transferencia);
			}else if(periodo > 30 && periodo <= 40) {
				transferencia.setTaxa(transferencia.getValor() * 0.047);
				transferenciaRepository.save(transferencia);
			}else if(periodo > 40){
				transferencia.setTaxa(transferencia.getValor() * 0.017);
				transferenciaRepository.save(transferencia);
			}else {
				logger.error("Taxa não aplicável, use outro tipo de operação.");
			}
		}
		if(transferencia.getTipoOperacao().contains("D")) {
			if(transferencia.getValor() <= 1000.00) {
				if(periodo == 0) {
				transferencia.setTaxa((transferencia.getValor() * 0.03) + 3.00);
				transferenciaRepository.save(transferencia);
			}else {
				logger.error("A transferência é inválida, precisa ser para o dia de hoje ou valor superior a 1000.00");
			}
			}
			if(transferencia.getValor() > 1000.00 && transferencia.getValor() <= 2000.00) {
				transferencia.setTaxa(12.00);
				transferenciaRepository.save(transferencia);
			}else {
				logger.error("O valor é inválido, precisa ser até 2.000");
			}
			if(transferencia.getValor() > 2000.00) {
				if(periodo != 0 && periodo > 10 && periodo <= 20) {
					transferencia.setTaxa(transferencia.getValor() * 0.082);
					transferenciaRepository.save(transferencia);
				}else if(periodo > 20 && periodo <= 30){
					transferencia.setTaxa(transferencia.getValor() * 0.069);
					transferenciaRepository.save(transferencia);
				}else if(periodo > 30 && periodo <= 40) {
					transferencia.setTaxa(transferencia.getValor() * 0.047);
					transferenciaRepository.save(transferencia);
				}else if(periodo > 40){
					transferencia.setTaxa(transferencia.getValor() * 0.017);
					transferenciaRepository.save(transferencia);
				}else {
					logger.error("Taxa não aplicável, verifique data e valor e tente novamente.");
				}
			}
		}
	}
	
	public List<Transferencia> listar() {
		return transferenciaRepository.findAll();
	}
	
	public void salvar(Transferencia transferencia, Long periodo) {
		calculoTaxa(transferencia, periodo);
	}
	
}
