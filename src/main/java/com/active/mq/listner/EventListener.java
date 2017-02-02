package com.active.mq.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author abhishekrai
 * @since 31/01/2017
 */
@Component
public class EventListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(EventListener.class);

    @Override
    public void onMessage(Message message) {
        logger.info("Message received as :" + message.toString());
    }
}
