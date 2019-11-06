package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoLibros;
import daos.DaoTemas;
import daos.DaoVentas;
import model.Libro;
import model.Tema;
import model.Venta;

@Service
public class ServiceLibrosImpl implements ServiceLibros {
	@Autowired
	DaoLibros daoLibros;
	
	@Autowired
	DaoVentas daoVentas;
	
	@Autowired
	DaoTemas daoTemas;
	
	@Override
	public List<Tema> recuperarTemas() {
		return daoTemas.findAll();
	}

	@Override
	public List<Libro> recuperarLibros() {
		return daoLibros.findAll();
	}

	@Override
	public List<Libro> recuperarLibrosPorTema(int idTema) {
		return daoLibros.findByIdTema(idTema);
	}

	@Override
	public List<Venta> recuperarVentasPorCliente(int idCliente) {
		return daoVentas.findByIdCliente(idCliente);
	}

}
