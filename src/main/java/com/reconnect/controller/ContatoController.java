package com.reconnect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")

public class ContatoController {

	
	public String inicio () {
		return "Descreva o serviço desejado!";
	}
	@RequestMapping(value = "/contato",method=RequestMethod.GET)
	public @ResponseBody String contato () {
		return "";
	}
}
