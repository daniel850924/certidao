/**
 * WsSgiAutenticacaoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WsSgiAutenticacaoLocator extends org.apache.axis.client.Service implements org.tempuri.WsSgiAutenticacao {

    public WsSgiAutenticacaoLocator() {
    }


    public WsSgiAutenticacaoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsSgiAutenticacaoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IWsSgiAutenticacao
    private java.lang.String BasicHttpBinding_IWsSgiAutenticacao_address = "http://172.30.11.27:88/WsSgi/WsSgiAutenticacao.svc";

    public java.lang.String getBasicHttpBinding_IWsSgiAutenticacaoAddress() {
        return BasicHttpBinding_IWsSgiAutenticacao_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName = "BasicHttpBinding_IWsSgiAutenticacao";

    public java.lang.String getBasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName() {
        return BasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName;
    }

    public void setBasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName = name;
    }

    public org.tempuri.IWsSgiAutenticacao getBasicHttpBinding_IWsSgiAutenticacao() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IWsSgiAutenticacao_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IWsSgiAutenticacao(endpoint);
    }

    public org.tempuri.IWsSgiAutenticacao getBasicHttpBinding_IWsSgiAutenticacao(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_IWsSgiAutenticacaoStub _stub = new org.tempuri.BasicHttpBinding_IWsSgiAutenticacaoStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IWsSgiAutenticacaoEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IWsSgiAutenticacao_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.IWsSgiAutenticacao.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_IWsSgiAutenticacaoStub _stub = new org.tempuri.BasicHttpBinding_IWsSgiAutenticacaoStub(new java.net.URL(BasicHttpBinding_IWsSgiAutenticacao_address), this);
                _stub.setPortName(getBasicHttpBinding_IWsSgiAutenticacaoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IWsSgiAutenticacao".equals(inputPortName)) {
            return getBasicHttpBinding_IWsSgiAutenticacao();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WsSgiAutenticacao");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IWsSgiAutenticacao"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IWsSgiAutenticacao".equals(portName)) {
            setBasicHttpBinding_IWsSgiAutenticacaoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
