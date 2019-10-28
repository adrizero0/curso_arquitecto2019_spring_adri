package presentacion;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daos.DaoContactos;
import model.Contacto;

public class TestContactos {

	public static void main(String[] args) {
		//INICIAR SPRING
		BeanFactory factory=new ClassPathXmlApplicationContext("springConfig.xml");
		
		//SOLICITAMOS A SPRING UNA IMPLEMENTACION DEL DAOCONTACTOS
		DaoContactos daoContactos=factory.getBean(DaoContactos.class);
		
		daoContactos.altaContacto(new Contacto(0, "contacto Spring", "spring@gmail.com", 30));
		List<Contacto> contactos=daoContactos.recuperarContactos();
		for(Contacto c:contactos) {
			System.out.println(c.getNombre());
		}
	}
}