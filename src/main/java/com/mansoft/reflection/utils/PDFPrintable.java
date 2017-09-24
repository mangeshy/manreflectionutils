package com.mansoft.reflection.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mangesh_y on 24/09/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PDFPrintable {
String value() default "";
String seperator() default "";
boolean isList() default  false;
Class<?> classType() default  java.lang.String.class;
}
