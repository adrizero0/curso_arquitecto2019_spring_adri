package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import daos.DaoCliente;
import model.Cliente;

@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {
	Cliente cliente;
	String repetirClave;
	
	@ManagedProperty ("#{daoClientes}")
	DaoCliente daoClientes;	
	
	public DaoCliente getDaoClientes() {
		return daoClientes;
	}

	public void setDaoClientes(DaoCliente daoClientes) {
		this.daoClientes = daoClientes;
	}

	public RegistroBean() {
		cliente=new Cliente();
	}
	
	public String getRepetirClave() {
		return repetirClave;
	}

	public void setRepetirClave(String repetirClave) {
		this.repetirClave = repetirClave;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String registrar() {
		daoClientes.registrar(cliente);
		return "login";
	}
	
}
