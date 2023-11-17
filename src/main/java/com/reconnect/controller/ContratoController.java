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

import com.reconnect.model.Contrato;
import com.reconnect.repository.ContratoRepository;

@Controller
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("contrato/listar.html");

		List<Contrato> contrato = contratoRepository.findAll();
		modelAndView.addObject("contrato", contrato);
		
		modelAndView.addObject("contratoedit", new Contrato());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("contrato/cadastro");

		modelAndView.addObject("contrato", new Contrato());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Contrato contrato) throws IOException {
 
		ModelAndView modelAndView = new ModelAndView("redirect:/contrato");
 
		contratoRepository.save(contrato);
 
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public String editar(Contrato contrato) {	
		System.out.println("Objeto: " + contrato.getNome());
		
		contrato.setConcluido(true);
		
		contratoRepository.save(contrato);
		
		return "redirect:/contrato";
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/contrato");
 
		contratoRepository.deleteById(id);
 
		return modelAndView;
	}

}
