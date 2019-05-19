package com.easysui.starter.configuration;

import com.easysui.cache.aspect.EasyCacheAspect;
import com.easysui.distribute.lock.aspect.EasyLockAspect;
import com.easysui.log.aspect.EasyLogAspect;
import com.easysui.validate.aspect.EasyValidateAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @author CHAO 2019/5/18 18:09
 */
@Slf4j
public class AspectConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "easysui.log", name = "enabled", havingValue = "true")
    public EasyLogAspect easyLogAspect() {
        log.info("easysui初始化日志切面");
        return new EasyLogAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "easysui.validate", name = "enabled", havingValue = "true")
    public EasyValidateAspect easyValidateAspect() {
        log.info("easysui初始化参数校验切面");
        return new EasyValidateAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "easysui.distribute-lock", name = "enabled", havingValue = "true")
    public EasyLockAspect easyLockAspect() {
        log.info("easysui初始化分布式锁切面");
        return new EasyLockAspect();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "easysui.cache", name = "enabled", havingValue = "true")
    public EasyCacheAspect easyCacheAspect() {
        log.info("easysui初始化缓存切面");
        return new EasyCacheAspect();
    }
}
