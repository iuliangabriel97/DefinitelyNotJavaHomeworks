/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucian.alexandru
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleData {
   
    private String locale;
    private List<String> countries;

    @PostConstruct
    public void populateCountries(){
        countries = new ArrayList<String>();
        countries.add("English");
        countries.add("Romanian");
    }

    public List<String> getCountries() {
       return countries;
    }

    public String getLocale() {
       return locale;
    }

    public void setLocale(String locale) {
       this.locale = locale;
    }

    //value change event listener
    public void localeChanged() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale("ro"));
    }
    
}
