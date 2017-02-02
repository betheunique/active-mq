package com.active.mq.sender;

import org.apache.activemq.ScheduledMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author abhishekrai
 * @since 31/01/2017
 */
@Component
public class EventSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendEvent(final String text) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                logger.info("Message created looks like :" + message);
                return message;
//                ObjectMessage objectMessage = session.createObjectMessage();
//                return objectMessage;
            }
        });
    }
//    public void send() {
//        jmsTemplate.send(((session) -> session.createObjectMessage()));
//    }

    public void sendScheduledEvent(final String reminder, final long delay) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                long timer = delay * 1000;
                Message message = session.createTextMessage(reminder);
                message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, timer);
                logger.info("Reminder message created with MQ scheduler :" + message);
                return message;
            }
        });
    }
}
