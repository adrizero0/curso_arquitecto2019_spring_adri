package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Contacto;

public class MapeadorContacto implements RowMapper<Contacto> {

	@Override
	public Contacto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Contacto(rs.getInt("idContacto"),
				rs.getString("nombre"),
				rs.getString("email"),
				rs.getInt("edad"));
	}

}
