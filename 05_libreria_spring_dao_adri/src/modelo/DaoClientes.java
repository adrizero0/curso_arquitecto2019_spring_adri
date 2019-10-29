package modelo;

import javabeans.Cliente;

public interface DaoClientes {

	boolean autenticar(String user, String pass);
	boolean autenticar2(String user, String pass);
	void registrar(Cliente c);

}