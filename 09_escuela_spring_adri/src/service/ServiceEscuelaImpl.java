package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoAlumnos;
import daos.DaoCursos;
import model.Alumno;
import model.Curso;


@Service ("sEscuela")
public class ServiceEscuelaImpl implements ServiceEscuela {
	@Autowired
	DaoAlumnos daoAlumnos;
	@Autowired
	DaoCursos daoCursos;
	
	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		if(!daoAlumnos.findAlumno(alumno.getDni())) {
			daoAlumnos.registrar(alumno);			
		}else {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Curso> obtenerCursos() {
		return daoCursos.findCursos();
	}

	@Override
	public List<Curso> obtenerCursos(Date fecha) {		
		return daoCursos.findCursos(fecha);
	}

	@Override
	public void borrarCurso(int idCurso) {
		daoCursos.deleteCurso(idCurso);		
	}

	@Override
	public int obtenerAlumnos(int idCurso) {		
		return daoAlumnos.findAlumnosPorCurso(idCurso) ;
	}

	@Override
	public List<String> obtenerCursosDenominaciones() {
		return daoCursos.obtenerCursosDenominaciones();
	}
}
