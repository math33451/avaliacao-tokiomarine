package com.marinetokio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marinetokio.dto.TransferenciaDto;
import com.marinetokio.model.Transferencia;
import com.marinetokio.repository.TransferenciaRepository;
import com.marinetokio.service.TransferenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/transferencia")
public class TransferenciaController {
	
	TransferenciaRepository transferenciaRepository;
	TransferenciaService transferenciaService;
	
	@GetMapping("/listar")
	public List<TransferenciaDto> listar(){
		List<TransferenciaDto> transferencia = transferenciaService.listar();
		return transferencia;
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Transferencia salvar(@RequestBody Transferencia transferencia, Long periodo) {
		return transferenciaService.salvar(transferencia, periodo);
	}
	
	

}
