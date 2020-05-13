package br.gov.mg.tce.certidao.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public abstract class PadraoDataModel<Objeto extends Object> extends ListDataModel<Objeto> implements SelectableDataModel<Objeto> {    
	  
    public PadraoDataModel() {  
    }  
    
    private List<Objeto> lista;
  
    public PadraoDataModel(List<Objeto> data) {  
        super(data);  
        lista = data;
    }  
      
    public Objeto getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Objeto> lista = (List<Objeto>) getWrappedData();  
        for(Objeto item : lista) {  
            if(rowKey.equalsIgnoreCase(item.hashCode()+""))  
                return item;  
        }  
          
        return null;  
    }  
    
    public List<Objeto> obterLista(){
    	return lista;
    }
  
    public Object getRowKey(Objeto item) {  
        return item.hashCode();  
    }
    
    public Integer getTamanho(){
    	
    	Integer tamanho = 0;
    	
    	if(lista != null){
    		tamanho = lista.size();
    	}
    	
    	return tamanho;
    }
}