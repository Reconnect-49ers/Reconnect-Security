package com.reconnect.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.reconnect.enums.Perfil;

public class UsuarioDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public UsuarioDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		Perfil perfil = usuario.getEmail().equals("irineu@com") ? Perfil.ADMIN : Perfil.USER;
		
		return AuthorityUtils.createAuthorityList(perfil.toString());
	}
	
	@Override
	public String getPassword() {
		return usuario.getSenha();
	}
	
	@Override
	public String getUsername() {
		return usuario.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	
	
	
	

}
