/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.dubbo.consumer;

import org.dubbo.framework.Invocation;
import org.dubbo.protocol.http.HttpClient;
import org.dubbo.provider.HelloService;

/**
 * @author lining
 * @version $Id: Consumer.java, v 0.1 2019-11-12 4:03 PM lining Exp $
 */
public class Consumer {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(),
                "sayHelloDubbo",
                new Object[]{"lining"},
                new Class[]{String.class});
        httpClient.post("localhost", 8080, invocation);
    }
}