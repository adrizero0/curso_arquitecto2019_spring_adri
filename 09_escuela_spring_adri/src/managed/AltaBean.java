package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Alumno;
import model.Curso;
import service.ServiceEscuela;

@ManagedBean(name="altaBean")
@RequestScoped
public class AltaBean {
	Alumno alumno;
	List<Curso> cursos;
	List<String> denominaciones;
	
	@ManagedProperty ("#{sEscuela}")
	ServiceEscuela serviceEscuela;
	
	public String registrar() {
		serviceEscuela.altaAlumno(alumno);		
		return "index";
	}
	
	public AltaBean() {
		alumno=new Alumno();
	}

	@PostConstruct
	public void inicio() {
		cursos=serviceEscuela.obtenerCursos();
		denominaciones=serviceEscuela.obtenerCursosDenominaciones();
	}
	
/////GETTERS & SETTERS
	
	
	public Alumno getAlumno() {
		return alumno;
	}

	public List<String> getDenominaciones() {
		return denominaciones;
	}

	public void setDenominaciones(List<String> denominaciones) {
		this.denominaciones = denominaciones;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public ServiceEscuela getServiceEscuela() {
		return serviceEscuela;
	}

	public void setServiceEscuela(ServiceEscuela serviceEscuela) {
		this.serviceEscuela = serviceEscuela;
	}
}
