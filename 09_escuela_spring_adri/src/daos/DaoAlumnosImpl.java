package daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
@Repository("daoAlumnos")
public class DaoAlumnosImpl implements DaoAlumnos {
	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;
	
	@Override
	public boolean findAlumno(int dni) {
		return em.find(Alumno.class, dni)!=null;
	}
	
	@Transactional
	@Override
	public void registrar(Alumno a) {
		em.persist(a);		
	}

	@Override
	public int findAlumnosPorCurso(int idCurso) {
		Query qr=em.createNamedQuery("Alumno.findAlumnosByCurso");
		qr.setParameter(1, idCurso);		
		return qr.getResultList().size();
	}
}
