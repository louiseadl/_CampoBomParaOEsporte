package com.telahome.campobomparaoesporte.Models;


import com.telahome.campobomparaoesporte.LoggedUsuario;

public class Equipamento {
	
	//atributos
	
	private long id;
	private Usuario usuario;
	private String descricao;
	private String nome;
	
	//getters n setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	
	//contrutores;
	
	public Equipamento(String nome, String descricao) {
		super();
		this.id = 0;
		this.usuario = LoggedUsuario.getUsuario();
		this.descricao = descricao;
		this.nome = nome;
	}
	public Equipamento() {
		super();
	}
	
	//metodos
	
	
	
	
}
