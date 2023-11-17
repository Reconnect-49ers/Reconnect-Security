package com.reconnect.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false, name = "data_hora")
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	@Column
	private boolean concluido;

	public Contrato(Long id, String nome, String email, String endereco, LocalDateTime data, boolean concluido) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.data = data;
		this.concluido = concluido;
	}

	public Contrato() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + ", data="
				+ data + ", concluido=" + concluido + "]";
	}
	
	
	

}
