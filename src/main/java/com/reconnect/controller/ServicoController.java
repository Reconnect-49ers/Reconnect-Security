package com.reconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.Servico;
import com.reconnect.repository.ServicoRepository;

@Controller
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	// lista todos os dados do banco servico
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("servico/listar.html");
 
		List<Servico> servicos = servicoRepository.findAll();
		modelAndView.addObject("servico", servicos);
 
		return modelAndView;
	}
	
}
