package com.reconnect.controller;

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

@Controller
public class MenuController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	
  @GetMapping("/profissionais")
  public String showProfissionaisPage() {
    return "profissionais";
  }
	
	@GetMapping("/servicos")
	public String showServicosPage() {
		return "servicos";
	}
	
	@GetMapping("/entrar")
	public String showEntrarPage() {
		return "entrar";
	}
  
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("index.html");
		
		List<Servico> servicos = servicoRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("servicos", servicos);
		modelAndView.addObject("usuarios", usuarios);
 
		return modelAndView;
	}
//	@GetMapping
//	public ModelAndView listarUsuarios() {
//		ModelAndView modelAndView = new ModelAndView("index.html");
//		
//		List<Usuario> usuarios = usuarioRepository.findAll();
//		modelAndView.addObject("usuarios", usuarios);
//		
//		return modelAndView;
//	}
	
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
