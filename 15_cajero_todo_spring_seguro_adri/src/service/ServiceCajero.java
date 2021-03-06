package service;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface ServiceCajero {
	Cuenta obtenerCuenta(int idCuenta);
	Cliente obtenerCliente(int idCliente);
	void extraccion(int idCuenta, double cantidad);
	void ingreso(int idCuenta, double cantidad);
	void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad);
	List<Cliente> obtenerTitulares(int idCuenta);
	List<Cliente> obtenerTitulares();
	List<Movimiento> obtenerMovimientos(int idCuenta);
	double obtenerSaldo(int idCuenta);
	
	void altaCuenta(Cuenta cuenta, int dni);
}
