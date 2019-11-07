package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;

public interface DaoMovimientos extends JpaRepository<Movimiento, Integer>{
	@Query("SELECT m FROM Movimiento m WHERE m.cuenta.numeroCuenta=?")
	List<Movimiento> findMovimientoByCuenta(int idCuenta);
}
