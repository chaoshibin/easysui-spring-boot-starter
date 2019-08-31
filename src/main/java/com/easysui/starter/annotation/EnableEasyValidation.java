package com.easysui.starter.annotation;

import com.easysui.starter.configuration.EasyValidationMarkerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author CHAO 2019/8/24 19:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EasyValidationMarkerConfiguration.class)
public @interface EnableEasyValidation {
}
