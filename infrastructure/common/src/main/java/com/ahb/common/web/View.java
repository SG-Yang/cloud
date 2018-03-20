package com.ahb.common.web;

import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface View extends Serializable{
    JsonObject toViewObj();
}
