package service;

import java.util.List;

import model.Cliente;
import model.Venta;

public interface ServiceCliente {
	Cliente getCliente(String user, String password);
	List<Venta> ventasCliente(int idCliente);
	void guardarCliente(Cliente cliente);
}
