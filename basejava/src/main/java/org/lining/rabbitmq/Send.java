/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @author lining
 * @version $Id: Send.java, v 0.1 2019-11-27 3:04 PM lining Exp $
 *
 * mq管理界面：http://45.76.0.226:15672/
 */
public class Send {

    /**
     * 配置信息
     */
    public static final String USER_NAME = "lining";
    public static final String HOST = "45.76.0.226";
    public static final String PASSWORD = "lining";
    public static final int PORT = 5672;

    /**
     * 队列信息
     */
    public static final String QUEUE_NAME = "hello_my_queue";
    //是否持久化队列
    public static final boolean DURABLE = true;
    //单机同时处理消息的个数
    public static final int PREFETCH = 1;

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);

        Scanner scanner = new Scanner(System.in);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                while (true){
                    String message = scanner.nextLine();
                    System.out.println("message is " + message);
                    //声明队列
                    channel.queueDeclare(QUEUE_NAME, DURABLE, false, false, null);

                    //发布消息
                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                    System.out.println("send message success: " + message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }


    }
}