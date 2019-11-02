package com.telahome.campobomparaoesporte.Models;

import com.telahome.campobomparaoesporte.LoggedUsuario;

public class Esporte {
	
	//atributos
	
	private long id;
	private int pin;
	private Usuario usuario;
	private String descricao;
	private String nome;

	
	//gettes n settes
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//construtores
	
	public Esporte() {
		super();
	}
	public Esporte(String nome, String descricao) {
		super();
		this.id = 0;
		this.pin = 0;
		this.usuario = LoggedUsuario.getUsuario();
		this.descricao = descricao;
		this.nome = nome;
	}
	
	//metodos
	

	
	
}
