/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author lining
 * @version $Id: Receiver.java, v 0.1 2019-11-27 4:50 PM lining Exp $
 */
public class Receiver {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Send.HOST);
        connectionFactory.setPort(Send.PORT);
        connectionFactory.setUsername(Send.USER_NAME);
        connectionFactory.setPassword(Send.PASSWORD);

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Send.QUEUE_NAME, false, false, false, null);
            System.out.println("监听消息中。。。");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(Send.QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}