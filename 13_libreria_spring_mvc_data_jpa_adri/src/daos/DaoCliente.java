package daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cliente;


public interface DaoCliente extends JpaRepository<Cliente, Integer> {
	//boolean autenticar(String user, String pass);
	//void registrar(Cliente c);	
	//Cliente getCliente(String user, String pass);
	
	Cliente findByUsuarioAndPassword(String user, String pass);
}
