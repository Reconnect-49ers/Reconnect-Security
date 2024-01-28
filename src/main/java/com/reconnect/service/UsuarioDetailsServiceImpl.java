package com.reconnect.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reconnect.model.Role;
import com.reconnect.model.Usuario;
import com.reconnect.repository.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
				
		if (usuario != null) {
			return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
					usuario.getSenha(),
					mapRolesToAuthorities(usuario.getRoles()));
		} else {
			throw new UsernameNotFoundException("invalid username or password");
		}
	}
	
	private Collection <?extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
		Collection <? extends GrantedAuthority> mapRoles = roles.stream()
		.map(role -> new SimpleGrantedAuthority(role.getName()))
		.collect(Collectors.toList());
		
		return mapRoles;
	}
	

}
