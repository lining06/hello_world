/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myclient;

/**
 * @author lining
 * @version $Id: ClientDemo.java, v 0.1 2019-10-16 5:38 PM lining Exp $
 */
public class ClientDemo {

    public static void main(String[] args) {
        RPCClientProxy rpcClientProxy = new RPCClientProxy();
        ILNHello hello = rpcClientProxy.clientProxy(ILNHello.class, "localhost", 8888);
        System.out.println(hello.sayHello("lining"));
    }
}