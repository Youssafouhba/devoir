package com.crud.Validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public class PhoneValidtor implements Validator {
    private static final int MIN_EMAIL_LENGTH = 10;
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String phone = (String) object;

        if (phone == null || phone.length() < MIN_EMAIL_LENGTH || phone.length()>13) {
            throw new ValidatorException(new FacesMessage("Invalide Phone Number !!!!"));
        }


    }
}
