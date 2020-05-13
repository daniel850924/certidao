package br.gov.mg.tce.certidao.converter;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import br.gov.mg.tcemg.model.IEntidade;

@FacesConverter("EntityConverterSelectOneMenu")
public class EntityConverterSelectOneMenu implements Converter {

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		
		if (value instanceof SelectItemGroup && ArrayUtils.isNotEmpty(((SelectItemGroup) value).getSelectItems())) {
			return ((SelectItemGroup) value).getLabel() != null ? ((SelectItemGroup) value).getLabel() : null;	
			
		} else if (value instanceof SelectItem) {
			
			if (((SelectItem) value).getValue() != null) {
				return obterString(((SelectItem) value).getValue());
			}
		}
		
		return obterString(value);
	}

	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		
		Object objeto = StringUtils.isBlank(valor) ? null : this.converteStringToObject(context, componente, valor);
		
		if (objeto instanceof IEntidade) {
			return (IEntidade) objeto;
		}

		return objeto;
	}
	
	@SuppressWarnings("rawtypes")
	public Object converteStringToObject(FacesContext context, UIComponent component, String value) {
		
		for (UIComponent componente : component.getChildren()) {
			Object obj = componente.getAttributes().get("value");
			
			if (obj instanceof Collection) {
				
				Object objetoSelecionado = null;
				
				for (Object single : ((Collection) obj)) {
					objetoSelecionado = obterObjetoSelecionado(value, single);
					
					if (objetoSelecionado != null) {
						return objetoSelecionado;
					}
				}
			}
		}
		
		return null;
	}

	private Object obterObjetoSelecionado(String value, Object single) {
		
		if (single instanceof SelectItemGroup) {
			
			if (ArrayUtils.isNotEmpty(((SelectItemGroup) single).getSelectItems())) {
				
				Object objetoSelecionado = null;
				
				for (SelectItem item : ((SelectItemGroup) single).getSelectItems()) {
					objetoSelecionado = obterObjeto(value, item.getValue());
					
					if (objetoSelecionado != null) {
						return objetoSelecionado;
					}
				}
			}	
			
		} else if (single instanceof SelectItem) {
			return obterObjeto(value, ((SelectItem) single).getValue());
		}
		
		return obterObjeto(value, single);
	}

	private Object obterObjeto(final String value, final Object single) {
		
		if (single instanceof IEntidade && value.equals(((IEntidade) single).getId().toString())) {
			return (IEntidade) single;
		}
		
		return null;
	}
	
	private String obterString(Object value) {
		
		if (value instanceof IEntidade) {
			return ((IEntidade) value).getId() != null ? ((IEntidade) value).getId().toString() : null;
		}

		return value.toString();
	}

}
