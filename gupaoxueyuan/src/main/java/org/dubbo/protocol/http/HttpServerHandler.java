/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.protocol.http;

import org.apache.commons.io.IOUtils;
import org.dubbo.framework.Invocation;
import org.dubbo.framework.Url;
import org.dubbo.register.Register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @author lining
 * @version $Id: HttpServerHandler.java, v 0.1 2019-11-12 11:27 AM lining Exp $
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){

        try {
            InputStream inputStream = req.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation)objectInputStream.readObject();

            //找实现类
            String interfaceName = invocation.getInterfaceName();
            Url url = Url.getUrl();
            Class implClass = Register.getService(interfaceName).get(url);

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String)method.invoke(implClass.newInstance(), invocation.getParams());

            OutputStream outputStream = resp.getOutputStream();
            IOUtils.write(result, outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}