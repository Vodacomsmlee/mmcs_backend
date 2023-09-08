package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface PhoneService {

    /* group */
    Map<String, Object> group_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> group_info(Map<String, Object> map) throws Exception;
    int group_add(Map<String, Object> map) throws Exception;
    int group_edt(Map<String, Object> map) throws Exception;
    int group_del(Map<String, Object> map) throws Exception;
}
