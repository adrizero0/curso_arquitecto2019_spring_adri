package daos;

import java.util.Date;
import java.util.List;

import model.Curso;
import model.CursoView;

public interface DaoCursos {
	Curso findCurso (int idCurso);
	List<Curso> findCursos ();
	List<Curso> findCursos (Date fecha);
	void deleteCurso(int idCurso);
	int findAlumnosPorCurso (int idCurso);	
}