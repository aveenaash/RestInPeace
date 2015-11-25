
package com.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GetAccountServiceImpl", targetNamespace = "http://service.soap.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GetAccountServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.soap.service.Account
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountById", targetNamespace = "http://service.soap.com/", className = "com.soap.service.GetAccountById")
    @ResponseWrapper(localName = "getAccountByIdResponse", targetNamespace = "http://service.soap.com/", className = "com.soap.service.GetAccountByIdResponse")
    @Action(input = "http://service.soap.com/GetAccountServiceImpl/getAccountByIdRequest", output = "http://service.soap.com/GetAccountServiceImpl/getAccountByIdResponse")
    public Account getAccountById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}