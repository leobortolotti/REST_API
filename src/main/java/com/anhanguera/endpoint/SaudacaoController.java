package com.anhanguera.endpoint;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.request.SaudacaoRequest;

@RestController
public class SaudacaoController {

	@RequestMapping(
			value="/saudacao",
			method=RequestMethod.GET
	)
	public SaudacaoRequest saudacaoGet(
				@RequestParam(
						value="nome", defaultValue="World"
				) String nome,
				@RequestParam(
						value="id", defaultValue="1"
				) int id
	){
		SaudacaoRequest s = new SaudacaoRequest(nome);
		s.setId(id);
		return s;
	}
	
	@RequestMapping(
			value="/saudacao",
			method=RequestMethod.POST,
			consumes="application/json"
			)
	public SaudacaoRequest saudacaoPost(@RequestBody SaudacaoRequest s){
		return s;
	}
	
}
