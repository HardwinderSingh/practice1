package code.Service;

public class ServiceXmlProxy implements code.Service.ServiceXml {
  private String _endpoint = null;
  private code.Service.ServiceXml serviceXml = null;
  
  public ServiceXmlProxy() {
    _initServiceXmlProxy();
  }
  
  public ServiceXmlProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceXmlProxy();
  }
  
  private void _initServiceXmlProxy() {
    try {
      serviceXml = (new code.Service.ServiceXmlServiceLocator()).getServiceXml();
      if (serviceXml != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceXml)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceXml)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceXml != null)
      ((javax.xml.rpc.Stub)serviceXml)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public code.Service.ServiceXml getServiceXml() {
    if (serviceXml == null)
      _initServiceXmlProxy();
    return serviceXml;
  }
  
  public java.lang.String getStatebyIdinXml(java.lang.String id) throws java.rmi.RemoteException{
    if (serviceXml == null)
      _initServiceXmlProxy();
    return serviceXml.getStatebyIdinXml(id);
  }
  
  
}