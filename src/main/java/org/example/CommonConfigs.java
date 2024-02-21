package org.example;
//Default command for rabbitMQ Docker image:
//docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
public class CommonConfigs {
    public static final String DEFAULT_QUEUE = "Queue-1";
    public static final String AMQP_URL = "amqp://guest:guest@localhost:5672/";
}
