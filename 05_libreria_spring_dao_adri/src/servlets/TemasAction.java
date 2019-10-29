package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import modelo.DaoTemas;


@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// LE INFORMA AL SERVIDOR DE APPS QUE SPRING VA A REALIZAR INYECCION DE OBJETOS EN ESTE SERVLET
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	@Autowired
	DaoTemas gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("temas", gtemas.obtenerTemas());
		
	}

}
