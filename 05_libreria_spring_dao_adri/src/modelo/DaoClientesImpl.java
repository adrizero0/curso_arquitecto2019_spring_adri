package modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javabeans.Cliente;
@Repository
public class DaoClientesImpl implements DaoClientes {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public boolean autenticar2(String user, String pass) {	
		String sql="select * from clientes where usuario=? and password=?";
		List<Cliente> clientes=template.query(sql, (rs,fila)->new Cliente(rs.getInt("idCliente"),
													rs.getString("usuario"),
													rs.getString("password"),
													rs.getString("email"),
													rs.getInt("telefono")), user,pass);
		return !clientes.isEmpty();
	}
	
	@Override
	public boolean autenticar(String user, String pass) {	
		String sql="SELECT COUNT(*) FROM clientes WHERE usuario=? AND password=?";
		return template.queryForObject(sql, Integer.class,user,pass)>0;		
	}

	@Override
	public void registrar(Cliente c) {		
       String sql="insert into clientes (usuario,password,email,telefono) ";
       sql+="values(?,?,?,?)";
       template.update(sql, c.getUsuario(),c.getPassword(),c.getEmail(),c.getTelefono());
     
	}

}
