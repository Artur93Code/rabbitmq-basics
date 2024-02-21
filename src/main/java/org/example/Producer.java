package org.example;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Producer {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
        Channel channel = connection.createChannel();

        System.out.println("What's your messages? Press -end to quit");
        boolean nextMessage = true;
        while (nextMessage) {
            System.out.print("Message: ");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();

            if(message.equals("-end")) {
                nextMessage = false;
            }
            else {
                channel.queueDeclare(CommonConfigs.DEFAULT_QUEUE, false, false, false, null);
                channel.basicPublish("", CommonConfigs.DEFAULT_QUEUE, null, message.getBytes());
            }
        }

        channel.close();
        connection.close();

        System.out.println("Message(s) send. Bye!");


    }
}