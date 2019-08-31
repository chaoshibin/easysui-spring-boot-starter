package com.easysui.starter.annotation;

import com.easysui.starter.configuration.EasyLockMarkerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author CHAO 2019/8/24 19:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EasyLockMarkerConfiguration.class)
public @interface EnableEasyLock {
}
