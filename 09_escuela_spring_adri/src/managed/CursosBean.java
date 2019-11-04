package managed;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Curso;
import model.CursoView;
import service.ServiceEscuela;

@ManagedBean(name="cursosBean")
@ViewScoped
public class CursosBean {
	@ManagedProperty ("#{sEscuela}")
	ServiceEscuela serviceEscuela;
	
	Date fecha;
	List<Curso> cursos;
	List<CursoView> cursosPorFecha;
	int idCurso;
	
	@PostConstruct
	public void inicio() {
		cursos=serviceEscuela.obtenerCursos();
	}
	
	public void buscar() {
		cursosPorFecha= serviceEscuela.obtenerCursos(fecha);
	}
	
	public void borrarCurso(int idCurso) {
		serviceEscuela.borrarCurso(idCurso);
		buscar();
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

	public List<CursoView> getCursosPorFecha() {
		return cursosPorFecha;
	}

	public void setCursosPorFecha(List<CursoView> cursosPorFecha) {
		this.cursosPorFecha = cursosPorFecha;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}	
	
}
