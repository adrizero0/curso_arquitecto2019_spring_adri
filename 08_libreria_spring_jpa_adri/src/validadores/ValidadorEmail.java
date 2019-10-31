package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vEmail")
public class ValidadorEmail implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String valor=(String) arg2;
		if(valor.contains(".")==false||valor.contains("@")==false) {
			ResourceBundle res=arg0.getApplication().getResourceBundle(arg0, "mens");			
			throw new ValidatorException(new FacesMessage(res.getString("error.email")));
		}
	}
}