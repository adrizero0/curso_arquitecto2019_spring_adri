package aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CajeroAdvice {
	private int ingresos;
	private int extracciones;
	
//	@After(value = "execution(void service.ServiceCajero.ingreso(double cant))")
	
	@After(value = "execution(* service.ServiceCajero.ingreso(..))")
	public void logIngresos(JoinPoint jp) {
		ingresos++;
		System.out.println("Ingresos totales: "+ingresos+", última cantidad "+ jp.getArgs()[1]);
	} 
	
	@Before(value = "execution(* service.ServiceCajero.extraccion(..))")
	public void logExtracciones(JoinPoint jp) {
		extracciones++;
		System.out.println("Extracciones totales: "+extracciones+", última a las "+new Date());
	}
	
	@Around(value = "execution(* service.ServiceCajero.extraccion(..))")
	public void controlExtraccion(ProceedingJoinPoint pjp) throws Throwable {
		Double cant=(Double) pjp.getArgs()[1];
		if(cant<=100) {
			pjp.proceed(); //SE PROCESA EL METODO			
		}else {
			System.out.println("Límite excedido. Máximo 100 pavitos macho.");
		}
	}
}
