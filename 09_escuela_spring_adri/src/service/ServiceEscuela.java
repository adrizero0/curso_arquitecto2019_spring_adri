package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;
import model.CursoView;

public interface ServiceEscuela {
	void altaAlumno(Alumno alumno);
	List<Curso> obtenerCursos();
	List<CursoView> obtenerCursos(Date fecha);
	void borrarCurso(int idCurso);	
	Curso obtenerCurso(int idCurso);
}
