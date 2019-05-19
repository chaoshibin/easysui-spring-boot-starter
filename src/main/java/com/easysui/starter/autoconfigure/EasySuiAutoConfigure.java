package com.easysui.starter.autoconfigure;

import com.easysui.http.RestTemplateConfiguration;
import com.easysui.http.RestTemplateProperties;
import com.easysui.mybatis.config.MyBatisAutoConfiguration;
import com.easysui.mybatis.properties.MyBatisProperties;
import com.easysui.redis.configuration.JedisConfiguration;
import com.easysui.redis.configuration.JedisProperties;
import com.easysui.starter.configuration.AppConfiguration;
import com.easysui.starter.configuration.AspectConfiguration;
import com.easysui.zookeeper.configuration.ZookeeperConfiguration;
import com.easysui.zookeeper.configuration.ZookeeperProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author CHAO 2019/5/18 14:15
 */
@Slf4j
@Configuration
@Import({AspectConfiguration.class,
        JedisConfiguration.class,
        ZookeeperConfiguration.class,
        RestTemplateConfiguration.class,
        MyBatisAutoConfiguration.class})
@EnableConfigurationProperties(AppConfiguration.class)
public class EasySuiAutoConfigure {

    @Bean
    @ConfigurationProperties("easysui.zookeeper")
    public ZookeeperProperties zookeeperProperties() {
        return new ZookeeperProperties();
    }

    @Bean
    @ConfigurationProperties("easysui.jedis")
    public JedisProperties jedisProperties() {
        return new JedisProperties();
    }

    @Bean
    @ConfigurationProperties("easysui.http")
    public RestTemplateProperties restTemplateProperties() {
        return new RestTemplateProperties();
    }

    @Bean
    @ConfigurationProperties("easysui.mybatis")
    public MyBatisProperties myBatisProperties() {
        return new MyBatisProperties();
    }
}
