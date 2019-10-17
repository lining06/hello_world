/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myclient;

import java.lang.reflect.Proxy;

/**
 * @author lining
 * @version $Id: RPCClientProxy.java, v 0.1 2019-10-16 5:52 PM lining Exp $
 */
public class RPCClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCli, final String host, final int port){
        return (T) Proxy.newProxyInstance(
                interfaceCli.getClassLoader(),
                new Class[]{interfaceCli},
                new RemoteInvocationHandler(host, port));
    }
}