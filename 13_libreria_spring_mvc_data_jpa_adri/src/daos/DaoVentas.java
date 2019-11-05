package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;


public interface DaoVentas extends JpaRepository<Venta, Integer>{
	//List<Venta> recuperarVentasCliente(int idCliente);
	//void registrarVenta(Venta venta);
	
	@Query("SELECT v FROM Venta v WHERE v.cliente.idCliente=?1")
	List<Venta> findByIdCliente(int idCliente);
}
