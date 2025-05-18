package com.spring.rest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.rest")
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MyConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // нет дополнительных конфигураций
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // все запросы идут через DispatcherServlet
    }
}