package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface AcntService {

    Map<String, Object> account_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> account_list(Map<String, Object> map) throws Exception;
}
