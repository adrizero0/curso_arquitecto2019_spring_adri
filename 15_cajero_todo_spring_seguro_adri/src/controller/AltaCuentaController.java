package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Transactional
	@PostMapping(value = "/doAltaCuenta")
	public String alta(@ModelAttribute("cuentaNueva") Cuenta cuentaNueva, @RequestParam("dni") int dni) {
		Cuenta cuenta=sCajero.obtenerCuenta(cuentaNueva.getNumeroCuenta());
		if(cuenta!=null) {
			return "error";
		} else {
			Cuenta c= new Cuenta(cuentaNueva.getNumeroCuenta(),
								 cuentaNueva.getSaldo(),
								 cuentaNueva.getTipocuenta());
			sCajero.altaCuenta(c, dni);	
			return "menu";
		}
	}
}

