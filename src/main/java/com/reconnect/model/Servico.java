package com.reconnect.model;

import java.util.Arrays;

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
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(columnDefinition = "longblob")
	private byte[] imagem;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	
	public Servico() {
		
	}

	public Servico(Long id, String nome, String descricao, byte[] imagem, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.usuario = usuario;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", imagem="
				+ Arrays.toString(imagem) + ", usuario=" + usuario + "]";
	}
	
}