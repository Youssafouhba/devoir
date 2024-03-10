package com.crud.Validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public class FirstNameValidtor  implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String firstname = (String) object;

        if (firstname == null) {
            throw new ValidatorException(new FacesMessage("!!!!"));
        }
    }
}
