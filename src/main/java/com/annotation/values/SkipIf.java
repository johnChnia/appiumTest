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
@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME) public @interface SkipIf {
    String platform();
}
