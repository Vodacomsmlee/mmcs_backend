package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface ConfService {
    List<Map<String, Object>> holiday_list(Map<String, Object> map) throws Exception;

    int holiday_add(Map<String, Object> map) throws Exception;

    int holiday_edt(Map<String, Object> map) throws Exception;

    int holiday_del(Map<String, Object> map) throws Exception;
}
