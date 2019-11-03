package daos;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface DaoCursos {
	List<Curso> findCursos ();
	List<Curso> findCursos (Date fecha);
	void deleteCurso(int idCurso);
	List<String> obtenerCursosDenominaciones();
}