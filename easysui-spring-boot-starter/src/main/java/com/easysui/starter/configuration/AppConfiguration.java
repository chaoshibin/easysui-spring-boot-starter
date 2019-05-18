package com.easysui.starter.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author CHAO 2019/5/19 2:16
 */
@Getter
@Setter
@ToString
@ConfigurationProperties("easysui.config")
public class AppConfiguration {
    private String appName;
}
