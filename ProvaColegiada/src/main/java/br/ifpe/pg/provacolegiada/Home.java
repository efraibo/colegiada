package br.ifpe.pg.provacolegiada;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {


	@GetMapping({"/","/home"})
	public String exibirHome() {
		return "home";
	}
	
}
