package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoCliente;
import daos.DaoVentas;
import model.Cliente;
import model.Venta;
@Service
public class ServiceClienteImpl implements ServiceCliente {
	@Autowired
	DaoCliente daoClientes;
	
	@Autowired
	DaoVentas daoVentas;
	
	@Override
	public Cliente getCliente(String user, String password) {		
		return daoClientes.findByUsuarioAndPassword(user, password);
	}

	@Override
	public List<Venta> ventasCliente(int idCliente){
		return daoVentas.findByIdCliente(idCliente);
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		if(!daoClientes.existsById(cliente.getIdCliente())) {
			daoClientes.saveAndFlush(cliente);
		}
	}
}
