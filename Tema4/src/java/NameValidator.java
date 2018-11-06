
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
@FacesValidator(value="nameValidator")
public class NameValidator implements Validator {
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (String.valueOf(value).length() < 3)
            throw new ValidatorException(new FacesMessage("Name is too short!"));
    }
}
