package daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mapeadores.MapeadorContacto;
import model.Contacto;

@Repository
public class DaoContactosImpl implements DaoContactos {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public void altaContacto() {		
		String sql="insert into contactos(nombre,email,edad) values(";
		sql+="'jdbc','jdbc@gmail.com',50)";
		template.update(sql);
	}
	
	@Override
	public void altaContacto(Contacto contacto) {
		String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
		template.update(sql, contacto.getNombre(),contacto.getEmail(),contacto.getEdad());	
	}
	
	@Override
	public List<Contacto> recuperarContactos(){		
		String sql="select * from contactos";
		//return template.query(sql, new MapeadorContacto());
		
		//OPCION 2 CON EXPRECION LAMBDA
		return template.query(sql, (rs,fila)->new Contacto(rs.getInt("idContacto"),
												rs.getString("nombre"),
												rs.getString("email"),
												rs.getInt("edad")));		
	}
	
	@Override
	public void eliminarContacto(int id) {
		String sql="delete from contactos where idContacto=?";
		template.update(sql, id);	
	}
}
