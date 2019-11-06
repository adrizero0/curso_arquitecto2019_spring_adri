package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.ServiceLibros;

@Controller
public class TemasController {
	@Autowired
	ServiceLibros sLibros;
	@RequestMapping(value="/temas",method = {RequestMethod.GET,RequestMethod.POST})
	public String recuperarTemas(HttpServletRequest request) {
		request.setAttribute("temas", sLibros.recuperarTemas());
		return "temas";
	}
	
	@PostMapping(value="/libros")
	public String obtenerLibros(@RequestParam("tema") int idTema,
			HttpServletRequest request) {
		if(idTema==0) {
			request.setAttribute("libros", sLibros.recuperarLibros());
		}else {
			request.setAttribute("libros", sLibros.recuperarLibrosPorTema(idTema));
		}
		return "forward:/temas";
	}
}
