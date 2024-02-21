package org.example;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
        Channel channel = connection.createChannel();

        DeliverCallback delliverCallback = (s, delivery) -> {
            System.out.println(new String(delivery.getBody(), StandardCharsets.UTF_8));
        };

        CancelCallback cancelCallback = s -> {
            System.out.println(s);
        };
        channel.basicConsume(CommonConfigs.DEFAULT_QUEUE, true, delliverCallback, cancelCallback);
    }
}
