package com.easysui.starter.configuration;

import com.easysui.cache.aspect.EasyCacheAspect;
import com.easysui.distribute.lock.aspect.EasyLockAspect;
import com.easysui.distribute.lock.service.DistributeLockService;
import com.easysui.distribute.lock.service.impl.RedisDistributeLockServiceImpl;
import com.easysui.log.aspect.EasyLogAspect;
import com.easysui.validation.aspect.EasyValidationAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author CHAO 2019/5/18 18:09
 */
@Slf4j
public class AspectConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(EasyLogMarkerConfiguration.Marker.class)
    public EasyLogAspect easyLogAspect() {
        log.info("easy sui初始化日志切面");
        return new EasyLogAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(EasyValidationMarkerConfiguration.Marker.class)
    public EasyValidationAspect easyValidationAspect() {
        log.info("easy sui初始化参数校验切面");
        return new EasyValidationAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(EasyLockMarkerConfiguration.Marker.class)
    public EasyLockAspect easyLockAspect() {
        log.info("easy sui初始化分布式锁切面");
        return new EasyLockAspect();
    }

    @Bean
    @ConditionalOnBean(EasyLockMarkerConfiguration.Marker.class)
    public DistributeLockService redisDistributeLockService() {
        log.info("easy sui初始化分布式锁切面");
        return new RedisDistributeLockServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(EasyCacheMarkerConfiguration.Marker.class)
    public EasyCacheAspect easyCacheAspect() {
        log.info("easy sui初始化缓存切面");
        return new EasyCacheAspect();
    }
}
