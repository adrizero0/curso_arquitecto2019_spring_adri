package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public void altaAlumno(Alumno alumno) {
		daoAlumnos.findAlumno(alumno.getDni());
	}

	@Override
	public List<Curso> obtenerCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> obtenerCursos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarCurso(int idCurso) {
		// TODO Auto-generated method stub
		
	}	

}
