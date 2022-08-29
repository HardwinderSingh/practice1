/**
 * RequestHandlerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package code.service;

public interface RequestHandlerService extends javax.xml.rpc.Service {
    public java.lang.String getRequestHandlerAddress();

    public code.service.RequestHandler getRequestHandler() throws javax.xml.rpc.ServiceException;

    public code.service.RequestHandler getRequestHandler(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
