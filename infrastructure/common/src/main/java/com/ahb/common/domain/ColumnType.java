package com.ahb.common.domain;

/**
 * Created by aheroboy on 22/3/2018.
 */
public enum ColumnType {
    STRING("string"),
    DOMAIN("int"),
    DOMAIN_MAP("map"),
    LONG("long");
    String type;

    ColumnType(String type) {
        this.type = type;
    }
    public static void main(String xargs[]){
        System.out.println(ColumnType.valueOf("STRING"));
    }

}
