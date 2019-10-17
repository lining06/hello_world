/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.rmi_myclient;

import java.io.Serializable;

/**
 * @author lining
 * @version $Id: RPCRequest.java, v 0.1 2019-10-16 5:48 PM lining Exp $
 */
public class RPCRequest implements Serializable {

    private static final long serialVersionUID = -14454634538560737L;
    private String className;

    private String methodName;

    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public RPCRequest setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public RPCRequest setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public RPCRequest setParameters(Object[] parameters) {
        this.parameters = parameters;
        return this;
    }
}