package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface AcntService {

    /* account */
    Map<String, Object> account_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> account_list(Map<String, Object> map) throws Exception;
    Map<String, Object> account_search_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> account_search_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> account_dept_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> account_info(Map<String, Object> map) throws Exception;
    int account_add(Map<String, Object> map) throws Exception;
    int account_edt(Map<String, Object> map) throws Exception;
    int account_dept_edt(Map<String, Object> map) throws Exception;
    int account_del(Map<String, Object> map) throws Exception;

    /* dept */
    List<Map<String, Object>> dept_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> dept_info(Map<String, Object> map) throws Exception;
    int dept_add(Map<String, Object> map) throws Exception;
    int dept_edt(Map<String, Object> map) throws Exception;
    int dept_del(Map<String, Object> map) throws Exception;
}
