package com.easysui.starter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chao Shibin 2019/8/24 19:52
 */
@Configuration
public class EasyCacheMarkerConfiguration {
    @Bean
    public Marker easyCacheMarkerBean() {
        return new Marker();
    }

    class Marker {
    }
}
