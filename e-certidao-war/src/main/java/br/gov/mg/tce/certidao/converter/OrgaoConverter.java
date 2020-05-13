package br.gov.mg.tce.certidao.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.convert.FacesConverter;

import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade;

@FacesConverter("converterOrgao")
public class OrgaoConverter extends AbstractConverter {

	private static final Map<String, Object> viewMap = new HashMap<String, Object>();
	
    @Override
    public String getConversionId(Object value) {

        if (value instanceof OrgaoEntidade) {
        	OrgaoEntidade entity = (OrgaoEntidade) value;
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getClass().getSimpleName());
            sb.append("@");
            sb.append(entity.getCodigoOrgaoEntidade());
            return sb.toString();
        }

        return null;
    }
    
	@Override
	public Map<String, Object> getViewRoot() {
		return viewMap;
	}
}