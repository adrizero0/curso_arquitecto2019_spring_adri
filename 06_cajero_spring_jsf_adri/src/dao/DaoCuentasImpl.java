package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentasImpl
 */
@Repository
public class DaoCuentasImpl implements DaoCuentas {
	@Autowired
	JdbcTemplate template;
	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		String sql="SELECT * FROM cuentas WHERE numeroCuenta=?";		
		return template.queryForObject(sql, (rs,fila)->new Cuenta(rs.getInt("numeroCuenta"),
												   rs.getDouble("saldo"),
												   rs.getString("tipocuenta")),numeroCuenta);
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		String sql="SELECT * FROM cuentas";		
		return template.query(sql, (rs,fila)->new Cuenta(rs.getInt("numeroCuenta"),
												   rs.getDouble("saldo"),
												   rs.getString("tipocuenta")));
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		String sql="UPDATE cuentas set saldo=?, tipocuenta=? WHERE numeroCuenta=? ";
		template.update(sql, cuenta.getSaldo(), cuenta.getTipocuenta(), cuenta.getNumeroCuenta());
	}  

}
