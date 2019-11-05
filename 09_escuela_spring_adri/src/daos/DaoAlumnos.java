package daos;

import model.Alumno;

public interface DaoAlumnos {
	boolean findAlumno(int dni);
	void registrar(Alumno a);
}