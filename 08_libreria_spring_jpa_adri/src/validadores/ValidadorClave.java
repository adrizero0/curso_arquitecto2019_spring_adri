package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vClave")
public class ValidadorClave implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		UIInput clave1=(UIInput)arg1.findComponent("clave1");
		String pass= (String)clave1.getValue();
		String pass2=(String) arg2;
		if(!pass.equals(pass2)) {
			ResourceBundle res=arg0.getApplication().getResourceBundle(arg0, "mens");			
			throw new ValidatorException(new FacesMessage(res.getString("error.clave")));
		}

	}

}
