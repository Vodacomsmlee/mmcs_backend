package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface CommService {
    List<Map<String, Object>> montrn_channel(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> montrn_conference_info(Map<String, Object> map) throws Exception;
    Map<String, Object> montrn_conference_total_cnt(Map<String, Object> map) throws Exception;
}
