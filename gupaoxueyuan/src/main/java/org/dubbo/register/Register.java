/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.register;

import org.dubbo.framework.Url;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lining
 * @version $Id: Register.java, v 0.1 2019-11-08 5:41 PM lining Exp $
 */
public class Register {

    private static Map<String, Map<Url, Class>> REGISTER = new HashMap<String, Map<Url, Class>>();

    public static void regist(Url url, String interfaceName, Class implClass){

        Map<Url, Class> urlClass = new HashMap<>();
        urlClass.put(url, implClass);
        REGISTER.put(interfaceName, urlClass);
    }

    public static Map<Url, Class> getService(String interfaceName){

        return REGISTER.get(interfaceName);
    }
}