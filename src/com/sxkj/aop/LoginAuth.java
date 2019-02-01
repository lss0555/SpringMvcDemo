package com.sxkj.aop;

import java.lang.annotation.*;

/**
 * @Description  ip权限控制
 **/
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAuth {
    boolean validate() default true;
}
