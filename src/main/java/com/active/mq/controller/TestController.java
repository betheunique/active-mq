package com.active.mq.controller;

import com.active.mq.sender.EventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author abhishekrai
 * @since 01/02/2017
 */
@Component
@Path("/active")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private EventSender eventSender;

    @Path("/test")
    @GET
    public int sendText(@QueryParam("text") String text) {
        long startTime = System.currentTimeMillis();
        eventSender.sendEvent(text);
        logger.info("Total Time taken to execute :" + (System.currentTimeMillis() - startTime));
        return 1;
    }

    @Path("/scheduler")
    @GET
    public int sendScheduledText(@QueryParam("reminder") String reminder, @QueryParam("delay") long delay) {
        long startTime = System.currentTimeMillis();
        eventSender.sendScheduledEvent(reminder, delay);
        logger.info("Total Time taken to execute scheduled event :" + (System.currentTimeMillis() - startTime));
        return 1;
    }
}
