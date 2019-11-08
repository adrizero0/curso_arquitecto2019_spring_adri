package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;


@Service
public class ServiceCajeroImpl implements ServiceCajero {	
	@Autowired
	DaoClientes daoClientes;
	@Autowired
	DaoCuentas daoCuentas;
	@Autowired
	DaoMovimientos daoMovimientos;
	
	@Override
	public Cuenta obtenerCuenta(int idCuenta) {
		return daoCuentas.findById(idCuenta).orElse(null);
	}	
	
	@Transactional
	@Override
	public void extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		if(cuenta.getSaldo()>=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.save(cuenta);
			Movimiento m=new Movimiento(0,cantidad,new Date(),"extracción",cuenta);
			daoMovimientos.save(m);
		}else {
			throw new RuntimeException();
		}		
	}
	
	@Transactional
	@Override
	public void ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		daoCuentas.save(cuenta);
		Movimiento m=new Movimiento(0,cantidad,new Date(),"ingreso",cuenta);
		daoMovimientos.save(m);
	}
	
	@Transactional
	@Override
	public void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		extraccion(idCuentaOrigen,cantidad);
		ingreso(idCuentaDestino,cantidad);
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {		
		return daoClientes.findClienteByIdCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {		
		return daoMovimientos.findMovimientoByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		return cuenta.getSaldo();
	}

	@Override
	public void altaCuenta(Cuenta cuenta) {
		if(!daoCuentas.existsById(cuenta.getNumeroCuenta())) {
			daoCuentas.saveAndFlush(cuenta);
		}else {
			throw new RuntimeException();
		}		
	}

	@Override
	public List<Cliente> obtenerTitulares() {
		return daoClientes.findAll();
	}
}
