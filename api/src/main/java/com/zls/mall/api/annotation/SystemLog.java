package com.zls.mall.api.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    //日志名称
    String description() default "";
    //日志类型
    LogType type();
}
