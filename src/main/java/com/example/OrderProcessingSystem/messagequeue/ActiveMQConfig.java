package com.example.OrderProcessingSystem.messagequeue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

@Configuration
@EnableJms
public class ActiveMQConfig {

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        //below configuration tells the JMS to use the embedded broker on localhost
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");

        //below code tells JMS to trust the class for serialization
        factory.setTrustedPackages(Arrays.asList("java.util", "java.lang", "com.example.OrderProcessingSystem.model"));
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.setPersistent(false); // for specifying in-memory
        broker.setUseJmx(true);
        broker.addConnector("vm://localhost");
        return broker;
    }
}
