
import java.net.URL;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
@FacesConverter(value = "stringConverter")
public class StringConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) throws ConverterException {
            try {
                return "===" + newValue + "===";
            } catch(Exception e) {
                throw new ConverterException("Hey, conversion error!");
            }
        }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        String v = String.valueOf(value);
        return v.substring(3, v.length() - 3);
    }
}
