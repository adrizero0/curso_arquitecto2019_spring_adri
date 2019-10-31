package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQueries({
	@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a"),
	@NamedQuery(name="Alumno.findAlumnoByCurso", query="SELECT a FROM Alumno a WHERE a.curso.idCurso=?1")
})
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int dni;

	private int edad;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idCurso",referencedColumnName = "idCurso")
	private Curso curso;

	public Alumno() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}