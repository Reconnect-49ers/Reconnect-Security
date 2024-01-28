package com.reconnect.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Servico;
import com.reconnect.model.Usuario;
import com.reconnect.repository.ServicoRepository;
import com.reconnect.repository.UsuarioRepository;

@Controller
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	// lista todos os dados do banco servico
	@GetMapping
	public ModelAndView listar(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("servico/listar.html");
		
		Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
		modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
 
		List<Servico> servicos = servicoRepository.findAll();
		modelAndView.addObject("servicos", servicos);
		
		List<Servico> servicosUser = servicoRepository.findByUserId(usuarioPrincipal.getId());
		modelAndView.addObject("servicosUser", servicosUser);
 
		return modelAndView;
	}
	
	// chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("servico/cadastro");
		
		Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
		modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		modelAndView.addObject("usuarios", usuarios);
		modelAndView.addObject("servico", new Servico());
 
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Servico servico, @RequestParam("file") MultipartFile file, 
			@RequestParam("usuario") Long  usuario) throws IOException {
		
		
		Usuario usuario1 = new Usuario();
		usuario1 = usuarioRepository.findById(usuario).orElse(null);
		servico.setUsuario(usuario1);
		
		try {
			byte[] filebyte = file.getBytes();
			servico.setImagem(filebyte);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/servico");
 
		servicoRepository.save(servico);
 
		return modelAndView;
	}
	
	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Servico servico = this.servicoRepository.getReferenceById(id);
		return servico.getImagem();
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("servico/editar");
		
		Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
		modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("listUsuarios", usuarios);
		
		Servico servico = servicoRepository.getReferenceById(id);
		modelAndView.addObject("servico", servico);
		
		Usuario us = servico.getUsuario();
		modelAndView.addObject("usuario", us);
 
		return modelAndView;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Servico servico, @RequestParam("file") MultipartFile file,
			@RequestParam("usuario") Long id) {	
		Usuario us = usuarioRepository.findById(id).orElse(null);
		servico.setUsuario(us);
		
		try {
			servico.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		servicoRepository.save(servico);
		ModelAndView modelAndView = new ModelAndView("redirect:/servico");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/servico");
		
		Servico serv = servicoRepository.findById(id).orElse(null);
		
		servicoRepository.deleteById(serv.getId());
 
		return modelAndView;
	}
	
	
}
