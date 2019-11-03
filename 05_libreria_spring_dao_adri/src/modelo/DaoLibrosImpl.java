/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javabeans.Libro;


@Repository
 public class DaoLibrosImpl implements DaoLibros {
	@Autowired
	JdbcTemplate template;	
    
    @Override
	public List<Libro> recuperarLibros(){    	   
        String sql="select * from libros";
        return template.query(sql, (rs,fila)->new Libro(rs.getInt("isbn"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getDouble("precio"),
                rs.getInt("paginas"),
                rs.getInt("idTema")));  
    }
    
    @Override
	public List<Libro> recuperarLibros(int idTema){
        String sql="select * from libros where idTema=?";
        return template.query(sql, (rs,fila)->new Libro(rs.getInt("isbn"),
										                rs.getString("titulo"),
										                rs.getString("autor"),
										                rs.getDouble("precio"),
										                rs.getInt("paginas"),
										                rs.getInt("idTema")),idTema);
    }
}
