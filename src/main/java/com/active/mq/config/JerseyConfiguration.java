package com.active.mq.config;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;


/**
 * @author abhishekrai
 * @since 01/02/2017
 */
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
    packages("com.active.mq");
}
}
