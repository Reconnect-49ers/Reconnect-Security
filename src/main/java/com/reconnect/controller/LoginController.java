package com.reconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Usuario;
import com.reconnect.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/entrar")
	public String login() {
		return "entrar";
	}
		
	@PostMapping("/login")
	public ModelAndView perfil(String email, String senha) {
		ModelAndView modelAndView = new ModelAndView("usuario/perfil");
		
		Usuario usuario = usuarioRepository.findByEmail(email).get();
		System.out.println(usuario);
		
		modelAndView.addObject("usuario", usuario);
		
		return modelAndView;
	}
	
	

}
