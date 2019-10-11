/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi.client;

import org.gupao.rmi.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author lining
 * @version $Id: ClientDemo.java, v 0.1 2019-10-10 4:51 PM lining Exp $
 */
public class ClientDemo {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHelloService helloService = (IHelloService)Naming.lookup("rmi://127.0.0.1/Hello");
        System.out.println(helloService.sayHello("lining"));
    }
}