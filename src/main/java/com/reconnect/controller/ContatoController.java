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
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Contato;
import com.reconnect.repository.ContatoRepository;
import com.reconnect.repository.ServicoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	
	// lista todos os dados do banco contato
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("contato/listar.html");
 
		List<Contato> contatos = contatoRepository.findAll();
		modelAndView.addObject("contatos", contatos);
 
		return modelAndView;
	}
		 
	@PostMapping("/modal-cadastrar")
	public ModelAndView cadastrar(Contato contato, @RequestParam("servico") Long id) throws IOException {
		
		contato.setServico(servicoRepository.findById(id).orElse(null));
		ModelAndView modelAndView = new ModelAndView("redirect:/contato");
 
		contatoRepository.save(contato);
 
		return modelAndView;
	}
		
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/contato");
 
		contatoRepository.deleteById(id);
 
		return modelAndView;
	}
		
}