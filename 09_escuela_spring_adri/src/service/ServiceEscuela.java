package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface ServiceEscuela {
	void altaAlumno(Alumno alumno);
	List<Curso> obtenerCursos();
	List<Curso> obtenerCursos(Date fecha);
	void borrarCurso(int idCurso);	
}
