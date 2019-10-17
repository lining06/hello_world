/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myserver;

/**
 * @author lining
 * @version $Id: LNHelloImpl.java, v 0.1 2019-10-16 5:35 PM lining Exp $
 */
public class LNHelloImpl implements ILNHello {
    @Override
    public String sayHello(String msg) {
        return "hello " + msg;
    }
}