package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import model.Cuenta;
import service.ServiceCajero;

@Controller
public class AltaCuentaController {
	@Autowired
	ServiceCajero sCajero;
	
	@GetMapping(value="/toAltaCuenta")
	public String inicio(HttpServletRequest request, Model model) {
		Cuenta cuenta=new Cuenta();
		model.addAttribute("cuentaNueva",cuenta);
		request.setAttribute("clientesLista", sCajero.obtenerTitulares());
		return "altacuenta";
	}
	
	@PostMapping(value = "/doAltaCuenta")
	public String alta(@ModelAttribute("cuentaNueva") Cuenta cuentaNueva) {
		Cuenta cuenta=sCajero.obtenerCuenta(cuentaNueva.getNumeroCuenta());
		if(cuenta!=null) {
			return "error";
		}else {
			List<Cliente> clientes=cuentaNueva.getClientes();
			for(Cliente cl:clientes) {
				int dni=cl.getDni();
				Cliente cliente=sCajero.obtenerCliente(dni);
			}
			sCajero.altaCuenta(cuentaNueva);
			return "menuadmin";
		}
	}
}

