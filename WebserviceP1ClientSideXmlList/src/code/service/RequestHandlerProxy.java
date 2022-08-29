package code.service;

public class RequestHandlerProxy implements code.service.RequestHandler {
  private String _endpoint = null;
  private code.service.RequestHandler requestHandler = null;
  
  public RequestHandlerProxy() {
    _initRequestHandlerProxy();
  }
  
  public RequestHandlerProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerProxy();
  }
  
  private void _initRequestHandlerProxy() {
    try {
      requestHandler = (new code.service.RequestHandlerServiceLocator()).getRequestHandler();
      if (requestHandler != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandler)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandler != null)
      ((javax.xml.rpc.Stub)requestHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public code.service.RequestHandler getRequestHandler() {
    if (requestHandler == null)
      _initRequestHandlerProxy();
    return requestHandler;
  }
  
  public java.lang.String getStateXml() throws java.rmi.RemoteException{
    if (requestHandler == null)
      _initRequestHandlerProxy();
    return requestHandler.getStateXml();
  }
  
  
}