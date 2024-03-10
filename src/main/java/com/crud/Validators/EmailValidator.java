package com.crud.Validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class EmailValidator implements Validator {
    private static final int MIN_EMAIL_LENGTH = 5;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        String email = (String) object;

        if(!isValidEmail(email) || email.length() < MIN_EMAIL_LENGTH){
            String errorMessage = getLocalizedErrorMessage("emailworderrror");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
        }
    }
    private Boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
    public static String getLocalizedErrorMessage(String key, Object... params) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
        String message = bundle.getString(key);
        return MessageFormat.format(message, params);
    }
}
