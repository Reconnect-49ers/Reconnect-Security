package com.reconnect.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Servico;
import com.reconnect.model.Usuario;
import com.reconnect.repository.ServicoRepository;
import com.reconnect.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping("/profissionais")
	public ModelAndView showProfissionaisPage(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("profissionais");
		
		if (principal != null) {
			Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
			modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		}
		
	  return modelAndView;
	}
	
	@GetMapping("/servicos")
	public ModelAndView showServicosPage(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("servicos");
		
		if (principal != null) {
			Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
			modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		}
		
		return modelAndView;
	}
  
	@GetMapping({"/index", "/"})
	public ModelAndView listar(HttpSession session, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("index.html");

		if (principal != null) {
			Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
			modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		}
	
		List<Servico> servicos = servicoRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("servicos", servicos);
		modelAndView.addObject("usuarios", usuarios);
 
		return modelAndView;
	}
	
	@GetMapping("/serv/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagenServico(@PathVariable("id") Long id) {
		Servico servico = this.servicoRepository.getReferenceById(id);
		return servico.getImagem();
	}
	
	@GetMapping("/user/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagenUser(@PathVariable("id") Long id) {
		Usuario usuario = this.usuarioRepository.getReferenceById(id);
		return usuario.getImagem();
	}

}
