package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente, Integer>{
	@Query("SELECT c FROM Cliente c JOIN c.cuentas cu WHERE cu.numeroCuenta=?1")
	List<Cliente> findClienteByIdCuenta (int idCuenta);
}