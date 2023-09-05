package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface AcntService {

    List<Map<String, Object>> account_list(Map<String, Object> map) throws Exception;
}
