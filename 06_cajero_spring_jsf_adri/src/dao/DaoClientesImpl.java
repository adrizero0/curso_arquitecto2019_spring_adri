package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cliente;

/**
 * Session Bean implementation class DaoClientesImpl
 */
@Repository
public class DaoClientesImpl implements DaoClientes {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		String sql="SELECT * FROM clientes c INNER JOIN titulares t ON c.dni=t.idCliente WHERE t.idCuenta=?";		
		return template.query(sql, (rs,fila)->new Cliente(rs.getInt("dni"),
												   rs.getString("direccion"),
												   rs.getString("nombre"),
												   rs.getInt("telefono")),idCuenta);	
	}

	@Override
	public void saveCliente(Cliente cliente) {
		String sql="insert into clientes (?,?,?,?)";
		template.update(sql, cliente.getDni(), cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono());		
	}

	@Override
	public void updateCliente(Cliente cliente) {
		String sql="UPDATE clientes set nombre=?, direccion=?,telefono=? WHERE dni=? ";
		template.update(sql, cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(), cliente.getDni());		
	}

	@Override
	public void removeCliente(int dni) {
		String sql="DELETE FROM clientes WHERE dni=? ";
		template.update(sql,dni);
	}
}
