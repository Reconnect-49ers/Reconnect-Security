package com.reconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
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
	
	

}
