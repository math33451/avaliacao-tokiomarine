package com.marinetokio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marinetokio.model.Transferencia;
import com.marinetokio.repository.TransferenciaRepository;
import com.marinetokio.service.TransferenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class TransferenciaController {
	
	TransferenciaRepository transferenciaRepository;
	TransferenciaService transferenciaService;
	
	@GetMapping("/transferencias")
	public List<Transferencia> listar(){
		return transferenciaRepository.findAll();
	}
	
	@PostMapping("/transferencia")
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<Transferencia> salvar(@RequestBody Transferencia transferencia, Long periodo) {
		transferenciaService.calculoTaxa(transferencia, periodo);
		return transferenciaRepository.findById(transferencia.getId());
	}
	
	

}
