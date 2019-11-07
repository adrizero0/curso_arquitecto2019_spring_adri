package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServiceCajero;
@Controller
public class OperacionesController {
	@Autowired
	ServiceCajero sCajero;
	
	@PostMapping(value = "/ingreso")
	public String ingreso(@RequestParam("cantidad") int cantidad,
						@SessionAttribute("cuenta") Cuenta cuenta,
						HttpServletRequest request) {
		sCajero.ingreso(cuenta.getNumeroCuenta(),cantidad);		
		return "operaciones";		
	}
	
	@PostMapping(value = "/extraccion")
	public String extraccion(@RequestParam("cantidad") int cantidad,
						@SessionAttribute("cuenta") Cuenta cuenta,
						HttpServletRequest request) {
		sCajero.extraccion(cuenta.getNumeroCuenta(),cantidad);		
		return "operaciones";
	}
	
	@PostMapping(value = "/transferencia")
	public String transferencia(@RequestParam("cantidad") int cantidad,
						@RequestParam("idCuentaDestino") int idCuentaDestino,
						@SessionAttribute("cuenta") Cuenta cuenta,
						HttpServletRequest request) {
		sCajero.transferencia(cuenta.getNumeroCuenta(), idCuentaDestino, cantidad);		
		return "operaciones";
	}

}
