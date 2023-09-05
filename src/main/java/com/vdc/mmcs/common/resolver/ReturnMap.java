package com.vdc.mmcs.common.resolver;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component("returnMap")
public class ReturnMap {
    public Map<String,Object> addMap(String key, Object data) {
        Map<String,Object> Map = new HashMap<>();
        Map.put(key, data);
        return Map;
    }
}
