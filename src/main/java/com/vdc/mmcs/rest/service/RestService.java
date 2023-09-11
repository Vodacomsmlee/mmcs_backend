package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface RestService {

    List<Map<String, Object>> get_common(Map<String, Object> map) throws Exception;
}
