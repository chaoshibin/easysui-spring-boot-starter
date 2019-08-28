package com.easysui.starter.configuration;

import com.easysui.core.configuration.AppConfiguration;
import com.easysui.http.RestTemplateConfiguration;
import com.easysui.http.RestTemplateProperties;
import com.easysui.mybatis.config.MyBatisAutoConfiguration;
import com.easysui.mybatis.properties.MyBatisProperties;
import com.easysui.redis.configuration.RedisConfig;
import com.easysui.zookeeper.configuration.ZookeeperProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.http.client.HttpClient;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * @author CHAO 2019/5/18 14:15
 */
@Slf4j
@Configuration
@Import({AspectConfiguration.class,
        RestTemplateConfiguration.class,
        RedisConfig.class,
        MyBatisAutoConfiguration.class})
public class EasySuiAutoConfiguration {

    @Bean
    @ConfigurationProperties("easysui.config")
    @ConditionalOnClass(CuratorFramework.class)
    public AppConfiguration appConfiguration() {
        return new AppConfiguration();
    }

    @Bean
    @ConfigurationProperties("easysui.zookeeper")
    @ConditionalOnProperty(prefix = "easysui.zookeeper", name = "enabled", havingValue = "true")
    @ConditionalOnClass(CuratorFramework.class)
    public ZookeeperProperties zookeeperProperties() {
        return new ZookeeperProperties();
    }

    @Bean
    @ConfigurationProperties("easysui.http")
    @ConditionalOnProperty(prefix = "easysui.http", name = "enabled", havingValue = "true")
    @ConditionalOnClass({HttpClient.class, RestTemplate.class})
    public RestTemplateProperties restTemplateProperties() {
        return new RestTemplateProperties();
    }

    @Bean
    @ConfigurationProperties("easysui.mybatis")
    @ConditionalOnBean(DataSource.class)
    @ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
    public MyBatisProperties myBatisProperties() {
        return new MyBatisProperties();
    }
}
