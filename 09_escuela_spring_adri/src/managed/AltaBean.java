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
	int idCurso;
	
	@ManagedProperty ("#{sEscuela}")
	ServiceEscuela serviceEscuela;
	
	public String registrar() {
		Curso curso=serviceEscuela.obtenerCurso(idCurso);
		alumno.setCurso(curso);
		serviceEscuela.altaAlumno(alumno);		
		return "index";
	}
	
	public AltaBean() {
		alumno=new Alumno();
	}

	@PostConstruct
	public void inicio() {
		cursos=serviceEscuela.obtenerCursos();
	}
	
/////GETTERS & SETTERS
	
	
	public Alumno getAlumno() {
		return alumno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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
