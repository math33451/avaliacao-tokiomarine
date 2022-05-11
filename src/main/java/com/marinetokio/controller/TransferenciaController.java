package com.marinetokio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marinetokio.repository.TransferenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/transferencia")
public class TransferenciaController {
	
	TransferenciaRepository transferenciaRepository;
	

}
