package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface DaoCursos extends JpaRepository<Curso, Integer>{
	//List<Curso> findAll();
	//Curso findByIdCurso(int idCurso);
	//void deleteCurso(int idCurso);
	
	@Query("SELECT c FROM Curso c WHERE c.fechaInicio>=?1")
	List<Curso> findByFechaInicio(Date fechaInicio);	
}
