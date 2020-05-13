package br.gov.mg.tce.certidao.datamodel;

import java.util.List;



/**
 * DataModel contendo uma lista de {@link ConsultarSolicitacaoDTO} para apresentar na tela de consultar Certidões
 *
 */
public class ConsultarSolicitacaoDataModel extends PadraoDataModel<ConsultarSolicitacaoDTO>{

	public ConsultarSolicitacaoDataModel(List<ConsultarSolicitacaoDTO> data){  
        super(data);  
    }  
}

