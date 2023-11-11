package com.reconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reconnect.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
