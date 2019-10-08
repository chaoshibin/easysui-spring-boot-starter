package com.easysui.starter.annotation;

import com.easysui.starter.configuration.EasyCacheMarkerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Chao Shibin 2019/8/24 19:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EasyCacheMarkerConfiguration.class)
public @interface EnableEasyCache {
}
