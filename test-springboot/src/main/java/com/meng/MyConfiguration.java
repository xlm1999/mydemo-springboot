package com.meng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public GpCoreService getGpCoreService() {
        return new GpCoreService();
    }
}
