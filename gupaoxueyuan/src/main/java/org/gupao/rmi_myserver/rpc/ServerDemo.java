/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myserver.rpc;

import org.gupao.rmi_myserver.ILNHello;
import org.gupao.rmi_myserver.LNHelloImpl;

/**
 * @author lining
 * @version $Id: ServerDemo.java, v 0.1 2019-10-17 10:55 AM lining Exp $
 */
public class ServerDemo {
    public static void main(String[] args) {
        ILNHello hello = new LNHelloImpl();

        RPCServer rpcServer = new RPCServer();
        rpcServer.publisher(hello, 8888);
    }
}