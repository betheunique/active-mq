package com.active.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author abhishekrai
 * @since 29/01/2017
 */
@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "com.active.mq")
//@Import(MQConfiguration.class)
public class SpringConfiguration {

    private static Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/src/main/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        registry.viewResolver(viewResolver);
//    }
//
//    /*
//     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
//     *
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
}
