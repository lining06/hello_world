/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lining
 * @version $Id: Test.java, v 0.1 2019-09-18 2:53 PM lining Exp $
 */
public class Test {

    public static void main(String[] args) {

        //举个例子 为了点进去看源码 定位、加载、注册
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
                "application-common",
                "application-beans.xml",
                "application-jdbc.xml");

        //创建bean的过程
        Object bean = app.getBean("member");
    }
}