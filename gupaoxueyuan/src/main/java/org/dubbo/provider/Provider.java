/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.provider;

import org.dubbo.framework.Url;
import org.dubbo.protocol.http.HttpServer;
import org.dubbo.register.Register;

/**
 * @author lining
 * @version $Id: Provider.java, v 0.1 2019-11-12 11:44 AM lining Exp $
 */
public class Provider {

    public static void main(String[] args) {
        //注册服务
        Url url = Url.getUrl();
        Register.regist(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());


    }
}