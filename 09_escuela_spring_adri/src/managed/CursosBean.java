package managed;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Curso;
import service.ServiceEscuela;

@ManagedBean(name="cursosBean")
@RequestScoped
public class CursosBean {
	@ManagedProperty ("#{sEscuela}")
	ServiceEscuela serviceEscuela;
	
	Date fecha;
	List<Curso> cursos;
	List<Curso> cursosPorFecha;
	int idCurso;
	int totalAlumnos;
	
	@PostConstruct
	public void inicio() {
		cursos=serviceEscuela.obtenerCursos();
		for(Curso c:cursos) {			
			totalAlumnos=serviceEscuela.obtenerAlumnos(c.getIdCurso());
		}
	}
	
	public void buscar() {
		cursosPorFecha= serviceEscuela.obtenerCursos(fecha);
		for(Curso c:cursosPorFecha) {			
			totalAlumnos=serviceEscuela.obtenerAlumnos(c.getIdCurso());
		}
	}
	
	public void borrarCurso() {
		serviceEscuela.borrarCurso(idCurso);
	}
	
/////GETTERS & SETTERS

	public ServiceEscuela getServiceEscuela() {
		return serviceEscuela;
	}

	public void setServiceEscuela(ServiceEscuela serviceEscuela) {
		this.serviceEscuela = serviceEscuela;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursosPorFecha() {
		return cursosPorFecha;
	}

	public void setCursosPorFecha(List<Curso> cursosPorFecha) {
		this.cursosPorFecha = cursosPorFecha;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getTotalAlumnos() {
		return totalAlumnos;
	}

	public void setTotalAlumnos(int totalAlumnos) {
		this.totalAlumnos = totalAlumnos;
	}	
	
}
