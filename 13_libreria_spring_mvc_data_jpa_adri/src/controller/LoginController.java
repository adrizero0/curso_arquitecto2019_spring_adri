package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import service.ServiceCliente;

@Controller
public class LoginController {
	@Autowired
	ServiceCliente sCliente;
	
	@PostMapping(value="/login")
	public String login(@RequestParam("user")String user,
						@RequestParam("pwd")String pwd, HttpSession session) {
		if(sCliente.getCliente(user, pwd)!=null) {
			Cliente cliente= sCliente.getCliente(user, pwd);
			session.setAttribute("cliente", cliente);
			return "menu";
		}else {
			return "error";
		}
	}
}
