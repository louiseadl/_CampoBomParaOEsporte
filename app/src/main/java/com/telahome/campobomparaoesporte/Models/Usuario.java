package com.telahome.campobomparaoesporte.Models;


public class Usuario {
	
	//atributos
	
	private long id;
	private String nome;
	private String email;
	private String senha;
	
	//getters n setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//construtores
	
	public Usuario() {
		super();
	}
	public Usuario( String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = 0;
	}
	
	//metodos
	
}
