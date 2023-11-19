package com.reconnect.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false, name = "data_hora")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime data;
	
	@Column(columnDefinition = "boolean default false")
	private boolean concluido;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false)
	private Servico servico;

	public Contrato(Long id, String endereco, LocalDateTime data, boolean concluido,
			Usuario usuario, Servico servico) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.data = data;
		this.concluido = concluido;
		this.usuario = usuario;
		this.servico = servico;
	}
	
	public Contrato() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", nome=" + usuario.getNome() + ", email=" + usuario.getEmail() + ", endereco=" + endereco + ", data="
				+ data + ", concluido=" + concluido + ", usuario=" + usuario + ", servico=" + servico + "]";
	}
	
	

}
