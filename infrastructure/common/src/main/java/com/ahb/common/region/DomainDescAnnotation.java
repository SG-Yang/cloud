package com.ahb.common.region;

import com.ahb.common.domain.ColumnType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by aheroboy on 23/3/2018.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainDescAnnotation {
    int index();
    ColumnType type();
}
