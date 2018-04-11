package com.ahb.common.handler;

/**
 * Created by aheroboy on 16/3/2018.
 */
public enum HandlerType {
    /*Region related.*/

    LOGIN,
    CREATE_REGION,
    REGION_MANAGE,
    CREATE_REGION_CHAIN,
    REGION_CREATOR_HANDLER_CHAIN,

    /* Domain related */
    DASHBOARD,
    VIEW,
    CREATE_INTERNAL_DOMAIN,
    CREATE_DOMAIN_BY_JOIN_REGION_DOMAINS,
    CREATE_DOMAIN_BY_JOIN_INTERNAL_DOMAINS,
    /*View related */
    ASSEMBLE_VIEW,
    /*Internal */
    MULTI_FROM

}
