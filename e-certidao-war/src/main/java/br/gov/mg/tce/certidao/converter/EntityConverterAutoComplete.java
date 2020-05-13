package br.gov.mg.tce.certidao.converter;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import br.gov.mg.tcemg.model.IEntidade;

@FacesConverter("EntityConverterAutoComplete")
public class EntityConverterAutoComplete implements Converter {

	public EntityConverterAutoComplete(){
		super();
	}
	
	@SuppressWarnings("rawtypes")
	public Object converteStringToObject(FacesContext context, UIComponent component, String value) {
		Object obj = null;
		
		if(component.getAttributes().get("lista") != null){
			obj = component.getAttributes().get("lista");
		}

		if (obj instanceof Collection) {
			for (Object single : ((Collection) obj)) {
				if (single instanceof IEntidade && value.equals(((IEntidade) single).getId().toString())) {
					return single;
				} else if (single instanceof SelectItem && ((SelectItem) single).getValue().equals(value)) {
					return ((SelectItem) single).getValue();
				}
			}
		}

		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		if (value instanceof IEntidade) {
			return ((IEntidade) value).getId() != null ? ((IEntidade) value).getId().toString() : null;
		} else if (value instanceof SelectItem && ((SelectItem) value).getValue() != null && !((SelectItem) value).getValue().toString().isEmpty()) {
			return ((SelectItem) value).getValue().toString();
		} else {
			return value.toString();
		}
	}

	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		if (valor == null || valor.length() == 0) {
			return null;
		}
		return this.converteStringToObject(context, componente, valor);
	}

}