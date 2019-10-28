package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javabeans.Libro;
import modelo.DaoLibros;


@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// LE INFORMA AL SERVIDOR DE APPS QUE SPRING VA A REALIZAR INYECCION DE OBJETOS EN ESTE SERVLET
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	@Autowired
	DaoLibros glibros;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("tema"));
	
		List<Libro> libros;
		//si idTema es 0 es que ha elegido todos
		if(idTema==0){
			libros=glibros.recuperarLibros();
		}
		else{
			libros=glibros.recuperarLibros(idTema);
		}
		request.setAttribute("libros", libros);
		
	}

}
