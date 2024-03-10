package com.crud.Bean;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;

@Named
@SessionScoped
public class LanguageBean {

    private Locale locale;

    @PostConstruct
    public void init() {
        String clientLanguage = "en";
        // Créer l'objet Locale correspondant
        locale = new Locale(clientLanguage);


        selectedLocale=clientLanguage;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    private String selectedLocale;

    public String getSelectedLocale() {
        return selectedLocale;
    }

    public void setSelectedLocale(String selectedLocale) {
        this.selectedLocale = selectedLocale;
    }


    public void changeLocale() {

        if (selectedLocale.equals("en")) {
            setLocale(Locale.ENGLISH);
        } else if (selectedLocale.equals("fr")) {
            setLocale(Locale.FRENCH);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid language selection."));
        }

    }
    public String getLocaleFromRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        return request.getHeader("Accept-Language");
    }

}