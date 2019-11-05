package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;
import model.Venta;

@Repository ("daoVentas")
public class DaoVentasImpl implements DaoVentas {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em; 
	@Override
	public List<Venta> recuperarVentasCliente(int idCliente) {
		Cliente cliente=em.find(Cliente.class, idCliente);
		return cliente.getVentas();
	}
	@Transactional
	@Override
	public void registrarVenta(Venta venta) {
		em.persist(venta);
		
	}


}
