package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;


public interface DaoLibros extends JpaRepository<Libro, Integer>{
	//List<Libro> obtenerLibros();
	
	@Query("SELECT l FROM Libro l WHERE l.tema.idTema=?1")
	List<Libro> findByIdTema(int idTema);
	
	//List<Libro> obtenerLibrosTema(int idTema);
}
