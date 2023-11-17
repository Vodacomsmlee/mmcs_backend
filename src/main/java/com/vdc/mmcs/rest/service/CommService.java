package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface CommService {
    List<Map<String, Object>> montrn_channel(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> montrn_conference_info(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> comm_conference_stt(Map<String, Object> map) throws Exception;


    List<Map<String, Object>> config_list(Map<String, Object> map) throws Exception;
    int config_add(Map<String, Object> map) throws Exception;
    int config_edt(Map<String, Object> map) throws Exception;
    int config_del(Map<String, Object> map) throws Exception;
}
