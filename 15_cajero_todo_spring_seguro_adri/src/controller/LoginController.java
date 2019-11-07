package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cuenta;
import service.ServiceCajero;

@Controller
public class LoginController {	
	@Autowired
	ServiceCajero sCajero;
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("idCuenta") int idCuenta,
						HttpSession sesion) {
		Cuenta cuenta=sCajero.obtenerCuenta(idCuenta);
		if(cuenta!=null) {
			sesion.setAttribute("cuenta", cuenta);
			return "operaciones";
		}else {
			return "error";
		}
	}
}
