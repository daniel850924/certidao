/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.mg.tce.facade;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

/**
 *
 * @author daniel.paula
 */
@Local
public interface CertidaoLimitesBOLocal extends BusinessDomainInterface<CertidaoLimites>{

	public void gerarCertidao(Integer qtde);
	
}
