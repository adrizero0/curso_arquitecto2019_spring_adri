package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Libro;
import model.Tema;
import service.ServiceLibros;

public class TemasController {
	@Autowired
	ServiceLibros sLibros;
	
	@RequestMapping(value = "/toTemas")
	public String inicio(HttpServletRequest request) {
		List<Tema> temas=sLibros.recuperarTemas();
		request.setAttribute("temas", temas);	
		return "temas";
	}
	
	@PostMapping(value="/libros")
	public String verTemas(HttpServletRequest request, @RequestParam("tema")int idTema) {
		if(idTema==0) {
			List<Libro> libros= sLibros.recuperarLibros();
			request.setAttribute("libros", libros);			
		}else {
			List<Libro> libros= sLibros.recuperarLibrosPorTema(idTema);
			request.setAttribute("libros", libros);			
		}		
		return "forward:/toTemas";		
	}	
}
