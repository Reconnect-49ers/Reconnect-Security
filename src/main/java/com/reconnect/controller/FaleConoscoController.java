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
import org.springframework.web.servlet.ModelAndView;

import com.reconnect.model.FaleConosco;
import com.reconnect.model.Usuario;
import com.reconnect.repository.FaleConoscoRepository;
import com.reconnect.repository.UsuarioRepository;

@Controller
@RequestMapping("/faleconosco")
public class FaleConoscoController {

	@Autowired
	private FaleConoscoRepository faleConoscoRepository;
	@Autowired 
	private UsuarioRepository usuarioRepository;

	// lista todos os dados do banco usuario
	@GetMapping
	public ModelAndView listar(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("faleconosco/listar.html");
		
		Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
		modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);

		List<FaleConosco> faleconosco = faleConoscoRepository.findAll();
		modelAndView.addObject("faleconosco", faleconosco);
		
		modelAndView.addObject("faleconoscoedit", new FaleConosco());

		return modelAndView;
	}

	// chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("faleconosco/cadastro");
		
		if (principal != null) {
			Usuario usuarioPrincipal = usuarioRepository.findByEmail(principal.getName());
			modelAndView.addObject("usuarioPrincipal", usuarioPrincipal);
		}

		modelAndView.addObject("faleconosco", new FaleConosco());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(FaleConosco faleConosco) throws IOException {

		
		ModelAndView modelAndView = new ModelAndView("redirect:/index");

		faleConoscoRepository.save(faleConosco);

		return modelAndView;
	}

	
	@PostMapping("/editar")
	public String editar(FaleConosco faleconosco) {	
		System.out.println("Objeto: " + faleconosco.getNome());
		
		faleconosco.setStatus(true);
		
		faleConoscoRepository.save(faleconosco);
		
		return "redirect:/faleconosco";
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/faleconosco");
 
		faleConoscoRepository.deleteById(id);
 
		return modelAndView;
	}



}
