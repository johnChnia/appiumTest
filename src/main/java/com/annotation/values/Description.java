package com.annotation.values;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author john
 *
 */

@Target(ElementType.TYPE) @Retention(RetentionPolicy.RUNTIME) public @interface Description {

    String value() default "";
}
