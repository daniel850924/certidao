package br.gov.mg.tce.certidao.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class AbstractConverter implements Converter {

    @Override
    public final Object getAsObject(FacesContext context, UIComponent c,
            String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return getViewRoot().get(value);
    }

    @Override
    public final String getAsString(FacesContext context, UIComponent c,
            Object value) {
        if (value != null) {
            String id = getConversionId(value);
            if (id == null || id.isEmpty()) {
                return null;
            }
            getViewRoot().put(id, value);
            return id;
        }
        return null;
    }
    //Every concrete class must provide an unique conversionId String
    //to every instance of the converted object
    public abstract String getConversionId(Object value);
    
    public abstract Map<String, Object> getViewRoot();
}