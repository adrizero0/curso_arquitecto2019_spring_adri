package daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Repository("daoCursos")
public class DaoCursosImpl implements DaoCursos {
	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;

	@Override
	public List<Curso> findCursos() {
		Query qr=em.createNamedQuery("Curso.findAll");	
		return qr.getResultList();
	}

	@Override
	public List<Curso> findCursos(Date fecha) {
		Query qr=em.createNamedQuery("Curso.findCursoByDate");	
		return qr.getResultList();
	}
	
	@Transactional
	@Override
	public void deleteCurso(int idCurso) {
		Curso curso= em.find(Curso.class, idCurso);
		if(curso!=null) {
			em.remove(curso);
		}		
	}
}
