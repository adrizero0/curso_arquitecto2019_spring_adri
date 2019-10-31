package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoCliente;
import daos.DaoVentas;
import model.Venta;

@ManagedBean
@RequestScoped
public class VentasBean {
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	@ManagedProperty ("#{daoVentas}")
	DaoVentas daoVentas;
	@ManagedProperty ("#{daoClientes}")
	DaoCliente daoClientes;	
	
	public DaoVentas getDaoVentas() {
		return daoVentas;
	}

	public void setDaoVentas(DaoVentas daoVentas) {
		this.daoVentas = daoVentas;
	}

	public DaoCliente getDaoClientes() {
		return daoClientes;
	}

	public void setDaoClientes(DaoCliente daoClientes) {
		this.daoClientes = daoClientes;
	}

	private List<Venta> ventas;
	@Transactional
	@PostConstruct
	public void inicio() {
		int idCliente=daoClientes
				.getCliente(loginBean.getUsuario(), loginBean.getPassword())
				.getIdCliente();
		ventas=daoVentas.recuperarVentasCliente(idCliente);
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
}
