package com.easysui.starter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CHAO 2019/8/24 19:52
 */
@Configuration
public class EasyLockMarkerConfiguration {
    @Bean
    public Marker easyLockMarkerBean() {
        return new Marker();
    }

    class Marker {
    }
}
