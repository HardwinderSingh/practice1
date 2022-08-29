/**
 * ServiceXmlServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package code.Service;

public class ServiceXmlServiceLocator extends org.apache.axis.client.Service implements code.Service.ServiceXmlService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceXmlServiceLocator() {
    }


    public ServiceXmlServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceXmlServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceXml
    private java.lang.String ServiceXml_address = "http://localhost:7080/WebserviceP2ServerSide/services/ServiceXml";

    public java.lang.String getServiceXmlAddress() {
        return ServiceXml_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceXmlWSDDServiceName = "ServiceXml";

    public java.lang.String getServiceXmlWSDDServiceName() {
        return ServiceXmlWSDDServiceName;
    }

    public void setServiceXmlWSDDServiceName(java.lang.String name) {
        ServiceXmlWSDDServiceName = name;
    }

    public code.Service.ServiceXml getServiceXml() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceXml_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceXml(endpoint);
    }

    public code.Service.ServiceXml getServiceXml(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            code.Service.ServiceXmlSoapBindingStub _stub = new code.Service.ServiceXmlSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceXmlWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceXmlEndpointAddress(java.lang.String address) {
        ServiceXml_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (code.Service.ServiceXml.class.isAssignableFrom(serviceEndpointInterface)) {
                code.Service.ServiceXmlSoapBindingStub _stub = new code.Service.ServiceXmlSoapBindingStub(new java.net.URL(ServiceXml_address), this);
                _stub.setPortName(getServiceXmlWSDDServiceName());
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
        if ("ServiceXml".equals(inputPortName)) {
            return getServiceXml();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Service.code", "ServiceXmlService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Service.code", "ServiceXml"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceXml".equals(portName)) {
            setServiceXmlEndpointAddress(address);
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
