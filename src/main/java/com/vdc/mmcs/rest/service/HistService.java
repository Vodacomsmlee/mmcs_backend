package com.vdc.mmcs.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface HistService {

    /* hist */
    Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> hist_rec_list(Map<String, Object> map) throws Exception;
    int hist_rec_Add(Map<String, Object> map, HttpServletRequest request, HttpSession session) throws Exception;
    List<Map<String, Object>> hist_conference_list(Map<String, Object> map) throws Exception;
    Map<String, Object> hist_conference_total_cnt(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> hist_conference_attendant_list(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> hist_conference_stt_list(Map<String, Object> map) throws Exception;
}
