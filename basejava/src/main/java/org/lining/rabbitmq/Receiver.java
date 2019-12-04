/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import static org.lining.rabbitmq.Send.EXCHANGE_NAME;

/**
 * @author lining
 * @version $Id: Receiver.java, v 0.1 2019-11-27 4:50 PM lining Exp $
 */
public class Receiver {

    /**
     * 队列信息
     */
    public static final String QUEUE_NAME = "queue_wy";
    //单机同时处理消息的个数
    public static final int PREFETCH = 1;
    //是否持久化队列
    public static final boolean DURABLE = false;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Send.HOST);
        connectionFactory.setPort(Send.PORT);
        connectionFactory.setUsername(Send.USER_NAME);
        connectionFactory.setPassword(Send.PASSWORD);

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            // 正常情况下，消息接收会按顺序分发消息
            // 这个属性：指该消费者在接收到队列里的消息但没有返回确认结果之前,队列不会将新的消息分发给该消费者。而是发给其它消费者，可用于分散单机压力造成的消息堆积。
            channel.basicQos(PREFETCH);
//            channel.queueDeclare(Send.QUEUE_NAME, Send.DURABLE, false, false, null);
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, Send.EXCHANGE_NAME, "");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                try {
                    doWork(message);
                }finally {
                    //手动ack
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    System.out.println("[Done, now ack] " + delivery.getEnvelope().getDeliveryTag());
                }

            };

            //设置非自动ack表示
            boolean autoAck = false;
            channel.basicConsume(queueName, autoAck, deliverCallback, consumerTag -> { });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void doWork(String message) {
        System.out.println("[Received message] '" + message + "'");
        for (char c : message.toCharArray()) {
            if (c == '.'){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("sleep err" + e.getMessage());
                }
            }
        }

    }
}