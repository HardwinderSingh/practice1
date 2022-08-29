/**
 * RequestHandlerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package code.service;

public class RequestHandlerServiceLocator extends org.apache.axis.client.Service implements code.service.RequestHandlerService {

    public RequestHandlerServiceLocator() {
    }


    public RequestHandlerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestHandlerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequestHandler
    private java.lang.String RequestHandler_address = "http://localhost:7080/WedServiceP1ServerSideXmlList/services/RequestHandler";

    public java.lang.String getRequestHandlerAddress() {
        return RequestHandler_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestHandlerWSDDServiceName = "RequestHandler";

    public java.lang.String getRequestHandlerWSDDServiceName() {
        return RequestHandlerWSDDServiceName;
    }

    public void setRequestHandlerWSDDServiceName(java.lang.String name) {
        RequestHandlerWSDDServiceName = name;
    }

    public code.service.RequestHandler getRequestHandler() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequestHandler_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestHandler(endpoint);
    }

    public code.service.RequestHandler getRequestHandler(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            code.service.RequestHandlerSoapBindingStub _stub = new code.service.RequestHandlerSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestHandlerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestHandlerEndpointAddress(java.lang.String address) {
        RequestHandler_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (code.service.RequestHandler.class.isAssignableFrom(serviceEndpointInterface)) {
                code.service.RequestHandlerSoapBindingStub _stub = new code.service.RequestHandlerSoapBindingStub(new java.net.URL(RequestHandler_address), this);
                _stub.setPortName(getRequestHandlerWSDDServiceName());
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
        if ("RequestHandler".equals(inputPortName)) {
            return getRequestHandler();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.code", "RequestHandlerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.code", "RequestHandler"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequestHandler".equals(portName)) {
            setRequestHandlerEndpointAddress(address);
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
