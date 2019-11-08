package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import model.Venta;
import service.ServiceLibros;

@Controller
public class VentasController {
	@Autowired
	ServiceLibros sLibros;
	
	@GetMapping(value = "/toVentas")
	public String inicio(@SessionAttribute("cliente") Cliente cliente, HttpServletRequest request) {
		List<Venta> ventas=sLibros.recuperarVentasPorCliente(cliente.getIdCliente());
		request.setAttribute("ventas",ventas);
		return "ventas";
	}
}
