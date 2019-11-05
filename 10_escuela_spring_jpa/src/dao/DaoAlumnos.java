package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface DaoAlumnos extends JpaRepository<Alumno,Integer>{
	
	@Query("SELECT COUNT(*) FROM Alumno a WHERE a.curso.idCurso=?1")
	int alumnosCurso(int idCurso);
}