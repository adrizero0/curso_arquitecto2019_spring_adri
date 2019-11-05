package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoAlumnos;
import daos.DaoCursos;
import model.Alumno;
import model.Curso;
import model.CursoView;


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
	@Transactional
	@Override
	public List<CursoView> obtenerCursos(Date fecha) {
		List<Curso> cursos=daoCursos.findCursos(fecha);
		List<CursoView> cursosView=new ArrayList<>();
		if(cursos==null||cursos.size()==0) {
			return null;
		}
		for(Curso c:cursos) {
			//CursoView cView=new CursoView(c,c.getAlumnos().size());
			CursoView cView=new CursoView(c,daoCursos.findAlumnosPorCurso(c.getIdCurso()));
			cursosView.add(cView);
		}
		return cursosView;
	}

	@Override
	public void borrarCurso(int idCurso) {
		daoCursos.deleteCurso(idCurso);
	}

	@Override
	public Curso obtenerCurso(int idCurso) {
		return daoCursos.findCurso(idCurso);
	}
}
