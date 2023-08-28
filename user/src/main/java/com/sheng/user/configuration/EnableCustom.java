package com.sheng.user.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DefaultEnableCustomImportSelector.class)
public @interface EnableCustom {

    boolean enabled() default true;

}
