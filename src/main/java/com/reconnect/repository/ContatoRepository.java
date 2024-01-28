package com.reconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reconnect.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	List<Contato> findAll();
	
	@Query(value = "SELECT contato.* FROM contato JOIN servico ON contato.servico_id = servico.id JOIN usuario  ON servico.usuario_id = usuario.id WHERE usuario.id = :id", nativeQuery = true)
    List<Contato> findByUserId(Long id);
}
