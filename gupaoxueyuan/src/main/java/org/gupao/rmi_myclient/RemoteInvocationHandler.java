/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myclient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lining
 * @version $Id: RemoteInvocationHandler.java, v 0.1 2019-10-16 6:04 PM lining Exp $
 */
public class RemoteInvocationHandler implements InvocationHandler{
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest rpcRequest = new RPCRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        TCPTransport tcpTransport = new TCPTransport(this.host, this.port);
        return tcpTransport.send(rpcRequest);
    }
}