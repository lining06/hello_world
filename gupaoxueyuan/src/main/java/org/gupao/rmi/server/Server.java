/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi.server;

import org.gupao.rmi.HelloServiceImpl;
import org.gupao.rmi.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author lining
 * @version $Id: Server.java, v 0.1 2019-10-10 4:57 PM lining Exp $
 */
public class Server {

    public static void main(String[] args) {
        try {
            //实现类继承了UnicastRemoteObject，创建一个远程服务
            IHelloService helloService = new HelloServiceImpl();

            //启动Registry
            LocateRegistry.createRegistry(1099);

            //注册中心 key - value
            Naming.rebind("rmi://127.0.0.1/Hello", helloService);
            System.out.println("service started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}