package com.sample;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
    public static void main(String[] args) {
        String queueName;
        if (args.length > 0) {
            queueName = args[0];
        } else {
            queueName = "demo";
        }
        ConnectionFactory factory = new ActiveMQConnectionFactory(
            "admin",
            "adminPassword",
            "tcp://localhost:61616"
        );
        Connection connection;
        try {
            connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageConsumer consumer = session.createConsumer(destination);
            System.out.println("Waiting for message of " + queueName + "...");
            consumer.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
