package com.crud.Validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public class PasswordValidtor implements Validator {
    private static final int MIN_EMAIL_LENGTH = 8;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String password = (String) object;

        if (password.length() < MIN_EMAIL_LENGTH || password.length() > 16) {
            throw new ValidatorException(new FacesMessage("Password doit contenaire au moins " + MIN_EMAIL_LENGTH + "!!!!"));
        }
    }
}
