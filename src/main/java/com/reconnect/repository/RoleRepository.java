package com.reconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reconnect.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
	
}
