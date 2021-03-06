package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import model.Movimiento;
import service.ServiceCajero;
@Controller
public class MovimientosController {
	@Autowired
	ServiceCajero sCajero;
	
	@GetMapping(value="/doMovimientos")
	public String movimientos(@SessionAttribute("cuenta") Cuenta cuenta,
						HttpServletRequest request) {
		List<Movimiento> movimientos=sCajero.obtenerMovimientos(cuenta.getNumeroCuenta());
		request.setAttribute("movimientos", movimientos);
		request.setAttribute("saldo", sCajero.obtenerSaldo(cuenta.getNumeroCuenta()));
		return "movimientos";
	}
	
}
