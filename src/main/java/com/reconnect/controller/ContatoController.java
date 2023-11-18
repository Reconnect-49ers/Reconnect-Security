package com.reconnect.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Contato;
import com.reconnect.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	// lista todos os dados do banco contato
		@GetMapping
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("contato/listar.html");
	 
			List<Contato> contatos = contatoRepository.findAll();
			modelAndView.addObject("contatos", contatos);
	 
			return modelAndView;
		}
		
		// chama a view cadastrar e passa um objeto vazio
		@GetMapping("/cadastrar")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("contato/cadastro");
	 
			modelAndView.addObject("contato", new Contato());
	 
			return modelAndView;
		}
		
		
		 
		@PostMapping("/cadastrar")
		public ModelAndView cadastrar(Contato contato) throws IOException {
	 
			
			ModelAndView modelAndView = new ModelAndView("redirect:/contato");
	 
			contatoRepository.save(contato);
	 
			return modelAndView;
		}
		
		
//		
//		@GetMapping("/{id}/editar")
//		public ModelAndView editar(@PathVariable Long id) {
//			ModelAndView modelAndView = new ModelAndView("contato/edicao");
//	 
//			Contato contato = contatoRepository.getReferenceById(id);
//			modelAndView.addObject("contato", contato);
//	 
//			return modelAndView;
//		}
//		
//		@PostMapping("/{id}/editar")
//		public ModelAndView editar(Contato contato) {		
//	 
//			contatoRepository.save(contato);
//			ModelAndView modelAndView = new ModelAndView("redirect:/contato");
//	 
//			return modelAndView;
//		}
//		
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/contato");
 
			contatoRepository.deleteById(id);
	 
			return modelAndView;
		}
		
	@GetMapping("/{id}")
		public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("contato/detalhar.html");
 
		Contato contato = contatoRepository.getReferenceById(id);
		modelAndView.addObject("contato", contato);
 
		return modelAndView;
	}
}