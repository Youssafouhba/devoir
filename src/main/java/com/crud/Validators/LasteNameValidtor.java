package com.crud.Validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public class LasteNameValidtor implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String lastname = (String) object;

        if (lastname == null) {
            throw new ValidatorException(new FacesMessage("!!!!"));
        }
    }
}
