package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import daos.DaoCliente;
import model.Cliente;
import service.ServiceCliente;

@Controller
public class RegistroController {
	@Autowired
	ServiceCliente sCliente;
	
	@GetMapping(value = "toRegistro")
	public String inicio(Model model) {
		Cliente cl=new Cliente();
		model.addAttribute("cliente",cl);
		return "registro";
	}
	
	@PostMapping(value="/registrar")
	public String registrar(@ModelAttribute("cliente") Cliente cliente) {		
		sCliente.guardarCliente(cliente);
		return "login";
	}
}
