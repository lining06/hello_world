/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author lining
 * @version $Id: IHelloService.java, v 0.1 2019-10-10 4:49 PM lining Exp $
 */
public interface IHelloService extends Remote{

    String sayHello(String msg) throws RemoteException;
}