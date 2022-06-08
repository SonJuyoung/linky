package com.example.linky.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Value("${spring.servlet.multipart.location}")
    private String uploadImagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:static/");

        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:///" + uploadImagePath + "/")
                .setCachePeriod(4000)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
