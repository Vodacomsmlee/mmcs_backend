package com.vdc.mmcs.rest.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ConfService {
    List<Map<String, Object>> holiday_list(Map<String, Object> map) throws Exception;
    int holiday_add(Map<String, Object> map) throws Exception;
    int holiday_edt(Map<String, Object> map) throws Exception;
    int holiday_del(Map<String, Object> map) throws Exception;


    /* conference */
    Map<String, Object> conference_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> conference_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> conference_info(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> conference_info_tel_no(Map<String, Object> map) throws Exception;
    int conference_add(Map<String, Object> map) throws Exception;
    int conference_edt(Map<String, Object> map) throws Exception;
    int conference_del(Map<String, Object> map) throws Exception;

    /* attendant */
    List<Map<String, Object>> attendant_list(Map<String, Object> map) throws Exception;
    int attendant_add(Map<String, Object> map) throws Exception;
    int attendant_autocall_edt(Map<String, Object> map) throws Exception;
    int attendant_pin_edt(Map<String, Object> map) throws Exception;
    int attendant_desc_edt(Map<String, Object> map) throws Exception;
    int attendant_del(Map<String, Object> map) throws Exception;


    /* conference_reserve */
    List<Map<String, Object>> reserve_all_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> reserve_list(Map<String, Object> map) throws Exception;
    int reserve_add(Map<String, Object> map) throws Exception;
    int reserve_edt(Map<String, Object> map) throws Exception;
    int reserve_del(Map<String, Object> map) throws Exception;
    int reserve_pause(Map<String, Object> map) throws Exception;


    /* hist */
    Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> hist_rec_list(Map<String, Object> map) throws Exception;
    int hist_rec_Add(Map<String, Object> map, HttpServletRequest request) throws Exception;
    List<Map<String, Object>> hist_conference_list(Map<String, Object> map) throws Exception;
    Map<String, Object> hist_conference_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> hist_conference_attendant_list(Map<String, Object> map) throws Exception;

}
