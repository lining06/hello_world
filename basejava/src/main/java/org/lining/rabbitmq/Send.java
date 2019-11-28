/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 * @author lining
 * @version $Id: Send.java, v 0.1 2019-11-27 3:04 PM lining Exp $
 */
public class Send {

    public static final String QUEUE_NAME = "hello_queue";
    public static final String USER_NAME = "lining";
    public static final String HOST = "45.76.0.226";
    public static final String PASSWORD = "lining";
    public static final int PORT = 5672;



    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello lining";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("send message success: " + message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}