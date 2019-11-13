/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.framework;

import java.io.Serializable;

/**
 * @author lining
 * @version $Id: Invocation.java, v 0.1 2019-11-12 11:36 AM lining Exp $
 */
public class Invocation implements Serializable{

    private String interfaceName;

    private String methodName;

    private Object[] params;

    private Class[] paramTypes;

    public Invocation(String interfaceName, String methodName, Object[] params, Class[] paramTypes) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public Invocation setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public Invocation setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Object[] getParams() {
        return params;
    }

    public Invocation setParams(Object[] params) {
        this.params = params;
        return this;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public Invocation setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
        return this;
    }
}