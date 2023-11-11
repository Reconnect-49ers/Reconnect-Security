package com.reconnect.controller;

import java.io.IOException;
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

import com.reconnect.model.Usuario;
import com.reconnect.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// lista todos os dados do banco usuario
		@GetMapping
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("usuario/listar.html");
	 
			List<Usuario> usuarios = usuarioRepository.findAll();
			modelAndView.addObject("usuarios", usuarios);
	 
			return modelAndView;
		}
		
		// chama a view cadastrar e passa um objeto vazio
		@GetMapping("/cadastrar")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("usuario/cadastro");
	 
			modelAndView.addObject("usuario", new Usuario());
	 
			return modelAndView;
		}
		
		//imagem
		 
		@PostMapping("/cadastrar")
		public ModelAndView cadastrar(Usuario usuario, @RequestParam("fileUsuario") MultipartFile file) throws IOException {
	 
			try {
				usuario.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
	 
			ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
	 
			usuarioRepository.save(usuario);
	 
			return modelAndView;
		}
		
		@GetMapping("/imagem/{id}")
		@ResponseBody
		public byte[] exibirImagen(@PathVariable("id") Long id) {
			Usuario usuario = this.usuarioRepository.getReferenceById(id);
			return usuario.getImagem();
		}
		
		@GetMapping("/{id}/editar")
		public ModelAndView editar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("usuario/edicao");
	 
			Usuario usuario = usuarioRepository.getReferenceById(id);
			modelAndView.addObject("usuario", usuario);
	 
			return modelAndView;
		}
		
		@PostMapping("/{id}/editar")
		public ModelAndView editar(Usuario usuario) {		
	 
			usuarioRepository.save(usuario);
			ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
	 
			return modelAndView;
		}
		
		@GetMapping("/{id}/excluir")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
	 
			usuarioRepository.deleteById(id);
	 
			return modelAndView;
		}
		
		@GetMapping("/{id}")
		public ModelAndView detalhar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("usuario/detalhar.html");
	 
			Usuario usuario = usuarioRepository.getReferenceById(id);
			modelAndView.addObject("usuario", usuario);
	 
			return modelAndView;
		}
}
