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

import com.reconnect.model.FaleConosco;
import com.reconnect.repository.FaleConoscoRepository;

@Controller
@RequestMapping("/faleconosco")
public class FaleConoscoController {

	@Autowired
	private FaleConoscoRepository faleConoscoRepository;

	// lista todos os dados do banco usuario
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("faleconosco/listar.html");

		List<FaleConosco> faleconosco = faleConoscoRepository.findAll();
		modelAndView.addObject("faleconosco", faleconosco);

		return modelAndView;
	}

	// chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("faleconosco/cadastro");

		modelAndView.addObject("faleconosco", new FaleConosco());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(FaleConosco faleConosco) throws IOException {

		
		ModelAndView modelAndView = new ModelAndView("redirect:/faleconosco");

		faleConoscoRepository.save(faleConosco);

		return modelAndView;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("faleconosco/edicao");
 
		FaleConosco faleconosco = faleConoscoRepository.getReferenceById(id);
		modelAndView.addObject("faleconosco", faleconosco);
 
		return modelAndView;
	}


}
