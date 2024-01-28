package com.reconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reconnect.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
	@Query(value = "SELECT * FROM servico s WHERE s.usuario_id = :id", nativeQuery = true)
    List<Servico> findByUserId(Long id);
}
