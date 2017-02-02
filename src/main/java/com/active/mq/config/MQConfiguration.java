package com.active.mq.config;

import com.active.mq.listner.EventListener;
import org.apache.activemq.spring.ActiveMQXAConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * @author abhishekrai
 * @since 29/01/2017
 */
@Configuration
@EnableJms
@ComponentScan({ "com.active.mq" })
public class MQConfiguration {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * Configuration is used to use schedule ActiveMQ's schedule message feature,
     * Local ActiveMQ browser Console will be not active.
     * @return
     */

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public BrokerService brokerService() throws Exception {
//        BrokerService brokerService = new BrokerService();
//        brokerService.setSchedulerSupport(true);
//        brokerService.addConnector("tcp://localhost:61616");
//        return brokerService;
//    }

    @Bean
    public EventListener eventListener() {
        return  new EventListener();
//        return eventListener;
    }

    @Bean
    public ActiveMQXAConnectionFactory connectionFactory() {
        ActiveMQXAConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName("testing-queue");
        return jmsTemplate;
    }

    @Bean
    public DefaultMessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setDestinationName("testing-queue");
        messageListenerContainer.setMessageListener(eventListener());
        return messageListenerContainer;
    }
}
