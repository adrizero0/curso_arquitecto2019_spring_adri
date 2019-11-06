package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import service.ServiceClientes;

@Controller
public class RegistroController {
	@Autowired
	ServiceClientes sClientes;
	//es ejecutado con la pulsación del enlace registrese 
	//de la página de login, y prepara el objeto Cliente
	//para recibir los datos de la request
	@GetMapping(value="toRegistro")
	public String inicio(Model model) {
		Cliente cl=new Cliente();
		model.addAttribute("cliente",cl);
		return "registro";
	}
	//es ejecutado al producirse el submit del formulario
	//de la página de registro
	@PostMapping(value="/registrar")
	public String registrar(@ModelAttribute("cliente") Cliente cliente) {
		sClientes.guardarCliente(cliente);
		return "login";
	}
}
