/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author lining
 * @version $Id: HelloServiceImpl.java, v 0.1 2019-10-10 4:49 PM lining Exp $
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService{

    public HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException{
        return "Hello " + msg;
    }
}