package com.reconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reconnect.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	@Query(value = "SELECT c.* FROM contrato c JOIN servico s ON c.servico_id = s.id JOIN usuario u ON s.usuario_id = u.id WHERE u.id = :id", nativeQuery = true)
    List<Contrato> findByUserId(Long id);
}
