/**
 * OrgaoEntidade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class OrgaoEntidade  implements java.io.Serializable {
    private java.lang.String cnpj;

    private java.lang.Integer codigoFuncao;

    private java.lang.Long codigoInstituicaoDbRap;

    private java.lang.Long codigoOrgaoEntidade;

    private java.lang.Integer codigoTipoEntidade;

    private java.lang.String codigoUnidadeOrcamentaria;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contato;

    private java.util.Calendar datAtivacao;

    private java.util.Calendar datCriacao;

    private java.util.Calendar datExtincao;

    private java.lang.String denominacaoOrgao;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco;

    private java.lang.String esfera;

    private java.lang.String funcao;

    private java.lang.String independente;

    private java.lang.Boolean institutoPrevidencia;

    private java.lang.String naturezaJuridica;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime regimeJuridico;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime[] regimePrevidenciario;

    private java.lang.String sglTipoEntidade;

    private java.lang.String sigla;

    private java.lang.String tipoEntidade;

    private java.lang.String tipoFundo;

    private java.lang.String tipoInstituicaoDbRap;

    private java.lang.String tipoRegimeContabil;

    public OrgaoEntidade() {
    }

    public OrgaoEntidade(
           java.lang.String cnpj,
           java.lang.Integer codigoFuncao,
           java.lang.Long codigoInstituicaoDbRap,
           java.lang.Long codigoOrgaoEntidade,
           java.lang.Integer codigoTipoEntidade,
           java.lang.String codigoUnidadeOrcamentaria,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contato,
           java.util.Calendar datAtivacao,
           java.util.Calendar datCriacao,
           java.util.Calendar datExtincao,
           java.lang.String denominacaoOrgao,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco,
           java.lang.String esfera,
           java.lang.String funcao,
           java.lang.String independente,
           java.lang.Boolean institutoPrevidencia,
           java.lang.String naturezaJuridica,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime regimeJuridico,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime[] regimePrevidenciario,
           java.lang.String sglTipoEntidade,
           java.lang.String sigla,
           java.lang.String tipoEntidade,
           java.lang.String tipoFundo,
           java.lang.String tipoInstituicaoDbRap,
           java.lang.String tipoRegimeContabil) {
           this.cnpj = cnpj;
           this.codigoFuncao = codigoFuncao;
           this.codigoInstituicaoDbRap = codigoInstituicaoDbRap;
           this.codigoOrgaoEntidade = codigoOrgaoEntidade;
           this.codigoTipoEntidade = codigoTipoEntidade;
           this.codigoUnidadeOrcamentaria = codigoUnidadeOrcamentaria;
           this.contato = contato;
           this.datAtivacao = datAtivacao;
           this.datCriacao = datCriacao;
           this.datExtincao = datExtincao;
           this.denominacaoOrgao = denominacaoOrgao;
           this.endereco = endereco;
           this.esfera = esfera;
           this.funcao = funcao;
           this.independente = independente;
           this.institutoPrevidencia = institutoPrevidencia;
           this.naturezaJuridica = naturezaJuridica;
           this.regimeJuridico = regimeJuridico;
           this.regimePrevidenciario = regimePrevidenciario;
           this.sglTipoEntidade = sglTipoEntidade;
           this.sigla = sigla;
           this.tipoEntidade = tipoEntidade;
           this.tipoFundo = tipoFundo;
           this.tipoInstituicaoDbRap = tipoInstituicaoDbRap;
           this.tipoRegimeContabil = tipoRegimeContabil;
    }


    /**
     * Gets the cnpj value for this OrgaoEntidade.
     * 
     * @return cnpj
     */
    public java.lang.String getCnpj() {
        return cnpj;
    }


    /**
     * Sets the cnpj value for this OrgaoEntidade.
     * 
     * @param cnpj
     */
    public void setCnpj(java.lang.String cnpj) {
        this.cnpj = cnpj;
    }


    /**
     * Gets the codigoFuncao value for this OrgaoEntidade.
     * 
     * @return codigoFuncao
     */
    public java.lang.Integer getCodigoFuncao() {
        return codigoFuncao;
    }


    /**
     * Sets the codigoFuncao value for this OrgaoEntidade.
     * 
     * @param codigoFuncao
     */
    public void setCodigoFuncao(java.lang.Integer codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }


    /**
     * Gets the codigoInstituicaoDbRap value for this OrgaoEntidade.
     * 
     * @return codigoInstituicaoDbRap
     */
    public java.lang.Long getCodigoInstituicaoDbRap() {
        return codigoInstituicaoDbRap;
    }


    /**
     * Sets the codigoInstituicaoDbRap value for this OrgaoEntidade.
     * 
     * @param codigoInstituicaoDbRap
     */
    public void setCodigoInstituicaoDbRap(java.lang.Long codigoInstituicaoDbRap) {
        this.codigoInstituicaoDbRap = codigoInstituicaoDbRap;
    }


    /**
     * Gets the codigoOrgaoEntidade value for this OrgaoEntidade.
     * 
     * @return codigoOrgaoEntidade
     */
    public java.lang.Long getCodigoOrgaoEntidade() {
        return codigoOrgaoEntidade;
    }


    /**
     * Sets the codigoOrgaoEntidade value for this OrgaoEntidade.
     * 
     * @param codigoOrgaoEntidade
     */
    public void setCodigoOrgaoEntidade(java.lang.Long codigoOrgaoEntidade) {
        this.codigoOrgaoEntidade = codigoOrgaoEntidade;
    }


    /**
     * Gets the codigoTipoEntidade value for this OrgaoEntidade.
     * 
     * @return codigoTipoEntidade
     */
    public java.lang.Integer getCodigoTipoEntidade() {
        return codigoTipoEntidade;
    }


    /**
     * Sets the codigoTipoEntidade value for this OrgaoEntidade.
     * 
     * @param codigoTipoEntidade
     */
    public void setCodigoTipoEntidade(java.lang.Integer codigoTipoEntidade) {
        this.codigoTipoEntidade = codigoTipoEntidade;
    }


    /**
     * Gets the codigoUnidadeOrcamentaria value for this OrgaoEntidade.
     * 
     * @return codigoUnidadeOrcamentaria
     */
    public java.lang.String getCodigoUnidadeOrcamentaria() {
        return codigoUnidadeOrcamentaria;
    }


    /**
     * Sets the codigoUnidadeOrcamentaria value for this OrgaoEntidade.
     * 
     * @param codigoUnidadeOrcamentaria
     */
    public void setCodigoUnidadeOrcamentaria(java.lang.String codigoUnidadeOrcamentaria) {
        this.codigoUnidadeOrcamentaria = codigoUnidadeOrcamentaria;
    }


    /**
     * Gets the contato value for this OrgaoEntidade.
     * 
     * @return contato
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] getContato() {
        return contato;
    }


    /**
     * Sets the contato value for this OrgaoEntidade.
     * 
     * @param contato
     */
    public void setContato(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contato) {
        this.contato = contato;
    }


    /**
     * Gets the datAtivacao value for this OrgaoEntidade.
     * 
     * @return datAtivacao
     */
    public java.util.Calendar getDatAtivacao() {
        return datAtivacao;
    }


    /**
     * Sets the datAtivacao value for this OrgaoEntidade.
     * 
     * @param datAtivacao
     */
    public void setDatAtivacao(java.util.Calendar datAtivacao) {
        this.datAtivacao = datAtivacao;
    }


    /**
     * Gets the datCriacao value for this OrgaoEntidade.
     * 
     * @return datCriacao
     */
    public java.util.Calendar getDatCriacao() {
        return datCriacao;
    }


    /**
     * Sets the datCriacao value for this OrgaoEntidade.
     * 
     * @param datCriacao
     */
    public void setDatCriacao(java.util.Calendar datCriacao) {
        this.datCriacao = datCriacao;
    }


    /**
     * Gets the datExtincao value for this OrgaoEntidade.
     * 
     * @return datExtincao
     */
    public java.util.Calendar getDatExtincao() {
        return datExtincao;
    }


    /**
     * Sets the datExtincao value for this OrgaoEntidade.
     * 
     * @param datExtincao
     */
    public void setDatExtincao(java.util.Calendar datExtincao) {
        this.datExtincao = datExtincao;
    }


    /**
     * Gets the denominacaoOrgao value for this OrgaoEntidade.
     * 
     * @return denominacaoOrgao
     */
    public java.lang.String getDenominacaoOrgao() {
        return denominacaoOrgao;
    }


    /**
     * Sets the denominacaoOrgao value for this OrgaoEntidade.
     * 
     * @param denominacaoOrgao
     */
    public void setDenominacaoOrgao(java.lang.String denominacaoOrgao) {
        this.denominacaoOrgao = denominacaoOrgao;
    }


    /**
     * Gets the endereco value for this OrgaoEntidade.
     * 
     * @return endereco
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this OrgaoEntidade.
     * 
     * @param endereco
     */
    public void setEndereco(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the esfera value for this OrgaoEntidade.
     * 
     * @return esfera
     */
    public java.lang.String getEsfera() {
        return esfera;
    }


    /**
     * Sets the esfera value for this OrgaoEntidade.
     * 
     * @param esfera
     */
    public void setEsfera(java.lang.String esfera) {
        this.esfera = esfera;
    }


    /**
     * Gets the funcao value for this OrgaoEntidade.
     * 
     * @return funcao
     */
    public java.lang.String getFuncao() {
        return funcao;
    }


    /**
     * Sets the funcao value for this OrgaoEntidade.
     * 
     * @param funcao
     */
    public void setFuncao(java.lang.String funcao) {
        this.funcao = funcao;
    }


    /**
     * Gets the independente value for this OrgaoEntidade.
     * 
     * @return independente
     */
    public java.lang.String getIndependente() {
        return independente;
    }


    /**
     * Sets the independente value for this OrgaoEntidade.
     * 
     * @param independente
     */
    public void setIndependente(java.lang.String independente) {
        this.independente = independente;
    }


    /**
     * Gets the institutoPrevidencia value for this OrgaoEntidade.
     * 
     * @return institutoPrevidencia
     */
    public java.lang.Boolean getInstitutoPrevidencia() {
        return institutoPrevidencia;
    }


    /**
     * Sets the institutoPrevidencia value for this OrgaoEntidade.
     * 
     * @param institutoPrevidencia
     */
    public void setInstitutoPrevidencia(java.lang.Boolean institutoPrevidencia) {
        this.institutoPrevidencia = institutoPrevidencia;
    }


    /**
     * Gets the naturezaJuridica value for this OrgaoEntidade.
     * 
     * @return naturezaJuridica
     */
    public java.lang.String getNaturezaJuridica() {
        return naturezaJuridica;
    }


    /**
     * Sets the naturezaJuridica value for this OrgaoEntidade.
     * 
     * @param naturezaJuridica
     */
    public void setNaturezaJuridica(java.lang.String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }


    /**
     * Gets the regimeJuridico value for this OrgaoEntidade.
     * 
     * @return regimeJuridico
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime getRegimeJuridico() {
        return regimeJuridico;
    }


    /**
     * Sets the regimeJuridico value for this OrgaoEntidade.
     * 
     * @param regimeJuridico
     */
    public void setRegimeJuridico(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime regimeJuridico) {
        this.regimeJuridico = regimeJuridico;
    }


    /**
     * Gets the regimePrevidenciario value for this OrgaoEntidade.
     * 
     * @return regimePrevidenciario
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime[] getRegimePrevidenciario() {
        return regimePrevidenciario;
    }


    /**
     * Sets the regimePrevidenciario value for this OrgaoEntidade.
     * 
     * @param regimePrevidenciario
     */
    public void setRegimePrevidenciario(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Regime[] regimePrevidenciario) {
        this.regimePrevidenciario = regimePrevidenciario;
    }


    /**
     * Gets the sglTipoEntidade value for this OrgaoEntidade.
     * 
     * @return sglTipoEntidade
     */
    public java.lang.String getSglTipoEntidade() {
        return sglTipoEntidade;
    }


    /**
     * Sets the sglTipoEntidade value for this OrgaoEntidade.
     * 
     * @param sglTipoEntidade
     */
    public void setSglTipoEntidade(java.lang.String sglTipoEntidade) {
        this.sglTipoEntidade = sglTipoEntidade;
    }


    /**
     * Gets the sigla value for this OrgaoEntidade.
     * 
     * @return sigla
     */
    public java.lang.String getSigla() {
        return sigla;
    }


    /**
     * Sets the sigla value for this OrgaoEntidade.
     * 
     * @param sigla
     */
    public void setSigla(java.lang.String sigla) {
        this.sigla = sigla;
    }


    /**
     * Gets the tipoEntidade value for this OrgaoEntidade.
     * 
     * @return tipoEntidade
     */
    public java.lang.String getTipoEntidade() {
        return tipoEntidade;
    }


    /**
     * Sets the tipoEntidade value for this OrgaoEntidade.
     * 
     * @param tipoEntidade
     */
    public void setTipoEntidade(java.lang.String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }


    /**
     * Gets the tipoFundo value for this OrgaoEntidade.
     * 
     * @return tipoFundo
     */
    public java.lang.String getTipoFundo() {
        return tipoFundo;
    }


    /**
     * Sets the tipoFundo value for this OrgaoEntidade.
     * 
     * @param tipoFundo
     */
    public void setTipoFundo(java.lang.String tipoFundo) {
        this.tipoFundo = tipoFundo;
    }


    /**
     * Gets the tipoInstituicaoDbRap value for this OrgaoEntidade.
     * 
     * @return tipoInstituicaoDbRap
     */
    public java.lang.String getTipoInstituicaoDbRap() {
        return tipoInstituicaoDbRap;
    }


    /**
     * Sets the tipoInstituicaoDbRap value for this OrgaoEntidade.
     * 
     * @param tipoInstituicaoDbRap
     */
    public void setTipoInstituicaoDbRap(java.lang.String tipoInstituicaoDbRap) {
        this.tipoInstituicaoDbRap = tipoInstituicaoDbRap;
    }


    /**
     * Gets the tipoRegimeContabil value for this OrgaoEntidade.
     * 
     * @return tipoRegimeContabil
     */
    public java.lang.String getTipoRegimeContabil() {
        return tipoRegimeContabil;
    }


    /**
     * Sets the tipoRegimeContabil value for this OrgaoEntidade.
     * 
     * @param tipoRegimeContabil
     */
    public void setTipoRegimeContabil(java.lang.String tipoRegimeContabil) {
        this.tipoRegimeContabil = tipoRegimeContabil;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrgaoEntidade)) return false;
        OrgaoEntidade other = (OrgaoEntidade) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cnpj==null && other.getCnpj()==null) || 
             (this.cnpj!=null &&
              this.cnpj.equals(other.getCnpj()))) &&
            ((this.codigoFuncao==null && other.getCodigoFuncao()==null) || 
             (this.codigoFuncao!=null &&
              this.codigoFuncao.equals(other.getCodigoFuncao()))) &&
            ((this.codigoInstituicaoDbRap==null && other.getCodigoInstituicaoDbRap()==null) || 
             (this.codigoInstituicaoDbRap!=null &&
              this.codigoInstituicaoDbRap.equals(other.getCodigoInstituicaoDbRap()))) &&
            ((this.codigoOrgaoEntidade==null && other.getCodigoOrgaoEntidade()==null) || 
             (this.codigoOrgaoEntidade!=null &&
              this.codigoOrgaoEntidade.equals(other.getCodigoOrgaoEntidade()))) &&
            ((this.codigoTipoEntidade==null && other.getCodigoTipoEntidade()==null) || 
             (this.codigoTipoEntidade!=null &&
              this.codigoTipoEntidade.equals(other.getCodigoTipoEntidade()))) &&
            ((this.codigoUnidadeOrcamentaria==null && other.getCodigoUnidadeOrcamentaria()==null) || 
             (this.codigoUnidadeOrcamentaria!=null &&
              this.codigoUnidadeOrcamentaria.equals(other.getCodigoUnidadeOrcamentaria()))) &&
            ((this.contato==null && other.getContato()==null) || 
             (this.contato!=null &&
              java.util.Arrays.equals(this.contato, other.getContato()))) &&
            ((this.datAtivacao==null && other.getDatAtivacao()==null) || 
             (this.datAtivacao!=null &&
              this.datAtivacao.equals(other.getDatAtivacao()))) &&
            ((this.datCriacao==null && other.getDatCriacao()==null) || 
             (this.datCriacao!=null &&
              this.datCriacao.equals(other.getDatCriacao()))) &&
            ((this.datExtincao==null && other.getDatExtincao()==null) || 
             (this.datExtincao!=null &&
              this.datExtincao.equals(other.getDatExtincao()))) &&
            ((this.denominacaoOrgao==null && other.getDenominacaoOrgao()==null) || 
             (this.denominacaoOrgao!=null &&
              this.denominacaoOrgao.equals(other.getDenominacaoOrgao()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.esfera==null && other.getEsfera()==null) || 
             (this.esfera!=null &&
              this.esfera.equals(other.getEsfera()))) &&
            ((this.funcao==null && other.getFuncao()==null) || 
             (this.funcao!=null &&
              this.funcao.equals(other.getFuncao()))) &&
            ((this.independente==null && other.getIndependente()==null) || 
             (this.independente!=null &&
              this.independente.equals(other.getIndependente()))) &&
            ((this.institutoPrevidencia==null && other.getInstitutoPrevidencia()==null) || 
             (this.institutoPrevidencia!=null &&
              this.institutoPrevidencia.equals(other.getInstitutoPrevidencia()))) &&
            ((this.naturezaJuridica==null && other.getNaturezaJuridica()==null) || 
             (this.naturezaJuridica!=null &&
              this.naturezaJuridica.equals(other.getNaturezaJuridica()))) &&
            ((this.regimeJuridico==null && other.getRegimeJuridico()==null) || 
             (this.regimeJuridico!=null &&
              this.regimeJuridico.equals(other.getRegimeJuridico()))) &&
            ((this.regimePrevidenciario==null && other.getRegimePrevidenciario()==null) || 
             (this.regimePrevidenciario!=null &&
              java.util.Arrays.equals(this.regimePrevidenciario, other.getRegimePrevidenciario()))) &&
            ((this.sglTipoEntidade==null && other.getSglTipoEntidade()==null) || 
             (this.sglTipoEntidade!=null &&
              this.sglTipoEntidade.equals(other.getSglTipoEntidade()))) &&
            ((this.sigla==null && other.getSigla()==null) || 
             (this.sigla!=null &&
              this.sigla.equals(other.getSigla()))) &&
            ((this.tipoEntidade==null && other.getTipoEntidade()==null) || 
             (this.tipoEntidade!=null &&
              this.tipoEntidade.equals(other.getTipoEntidade()))) &&
            ((this.tipoFundo==null && other.getTipoFundo()==null) || 
             (this.tipoFundo!=null &&
              this.tipoFundo.equals(other.getTipoFundo()))) &&
            ((this.tipoInstituicaoDbRap==null && other.getTipoInstituicaoDbRap()==null) || 
             (this.tipoInstituicaoDbRap!=null &&
              this.tipoInstituicaoDbRap.equals(other.getTipoInstituicaoDbRap()))) &&
            ((this.tipoRegimeContabil==null && other.getTipoRegimeContabil()==null) || 
             (this.tipoRegimeContabil!=null &&
              this.tipoRegimeContabil.equals(other.getTipoRegimeContabil())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCnpj() != null) {
            _hashCode += getCnpj().hashCode();
        }
        if (getCodigoFuncao() != null) {
            _hashCode += getCodigoFuncao().hashCode();
        }
        if (getCodigoInstituicaoDbRap() != null) {
            _hashCode += getCodigoInstituicaoDbRap().hashCode();
        }
        if (getCodigoOrgaoEntidade() != null) {
            _hashCode += getCodigoOrgaoEntidade().hashCode();
        }
        if (getCodigoTipoEntidade() != null) {
            _hashCode += getCodigoTipoEntidade().hashCode();
        }
        if (getCodigoUnidadeOrcamentaria() != null) {
            _hashCode += getCodigoUnidadeOrcamentaria().hashCode();
        }
        if (getContato() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContato());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContato(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDatAtivacao() != null) {
            _hashCode += getDatAtivacao().hashCode();
        }
        if (getDatCriacao() != null) {
            _hashCode += getDatCriacao().hashCode();
        }
        if (getDatExtincao() != null) {
            _hashCode += getDatExtincao().hashCode();
        }
        if (getDenominacaoOrgao() != null) {
            _hashCode += getDenominacaoOrgao().hashCode();
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
        }
        if (getEsfera() != null) {
            _hashCode += getEsfera().hashCode();
        }
        if (getFuncao() != null) {
            _hashCode += getFuncao().hashCode();
        }
        if (getIndependente() != null) {
            _hashCode += getIndependente().hashCode();
        }
        if (getInstitutoPrevidencia() != null) {
            _hashCode += getInstitutoPrevidencia().hashCode();
        }
        if (getNaturezaJuridica() != null) {
            _hashCode += getNaturezaJuridica().hashCode();
        }
        if (getRegimeJuridico() != null) {
            _hashCode += getRegimeJuridico().hashCode();
        }
        if (getRegimePrevidenciario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegimePrevidenciario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegimePrevidenciario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSglTipoEntidade() != null) {
            _hashCode += getSglTipoEntidade().hashCode();
        }
        if (getSigla() != null) {
            _hashCode += getSigla().hashCode();
        }
        if (getTipoEntidade() != null) {
            _hashCode += getTipoEntidade().hashCode();
        }
        if (getTipoFundo() != null) {
            _hashCode += getTipoFundo().hashCode();
        }
        if (getTipoInstituicaoDbRap() != null) {
            _hashCode += getTipoInstituicaoDbRap().hashCode();
        }
        if (getTipoRegimeContabil() != null) {
            _hashCode += getTipoRegimeContabil().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrgaoEntidade.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoEntidade"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnpj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "cnpj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoFuncao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoFuncao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoInstituicaoDbRap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoInstituicaoDbRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOrgaoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoOrgaoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoTipoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoUnidadeOrcamentaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoUnidadeOrcamentaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "contato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datAtivacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "datAtivacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datCriacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "datCriacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datExtincao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "datExtincao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominacaoOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "denominacaoOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Endereco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esfera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "esfera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("funcao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "funcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("independente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "independente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institutoPrevidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "institutoPrevidencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naturezaJuridica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "naturezaJuridica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimeJuridico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "regimeJuridico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Regime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimePrevidenciario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "regimePrevidenciario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Regime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Regime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sglTipoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "sglTipoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sigla");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "sigla"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFundo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoFundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoInstituicaoDbRap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoInstituicaoDbRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRegimeContabil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoRegimeContabil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
