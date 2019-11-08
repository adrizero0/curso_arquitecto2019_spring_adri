package controller;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import service.ServiceCajero;

@Controller
public class AltaCuentaController {
	@Autowired
	ServiceCajero sCajero;
	
	@GetMapping(value="/altaCuenta")
	public String inicio(HttpServletRequest request) {
		Cuenta cuenta=new Cuenta();
		request.setAttribute("clientes", sCajero.obtenerTitulares());
		return "altaCuenta";
	}
	
	@PostMapping(value = "/doAltaCuenta")
	public String login(@RequestParam("numeroCuenta") int numeroCuenta,
						@RequestParam("tipocuenta") String tipocuenta,
						@RequestParam("cliente") Cliente cliente) {
		Cuenta cuenta=sCajero.obtenerCuenta(numeroCuenta);
		if(cuenta!=null) {
			return "operaciones";
		}else {
			return "error";
		}
	}
}

//private int numeroCuenta;
//
//private double saldo;
//
//private String tipocuenta;
//
////bi-directional many-to-one association to Movimiento
//@OneToMany(mappedBy="cuenta")
//private List<Movimiento> movimientos;
//
////bi-directional many-to-many association to Cliente
//@ManyToMany(mappedBy="cuentas")
//private List<Cliente> clientes;

