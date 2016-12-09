package com.anhanguera.request;

public class SaudacaoRequest {

	private String nome;
	private int id;
	
	public SaudacaoRequest(){
		
	}

	public SaudacaoRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
