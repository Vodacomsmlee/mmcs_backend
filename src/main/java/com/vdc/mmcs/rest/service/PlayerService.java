package com.vdc.mmcs.rest.service;

import java.util.List;
import java.util.Map;

public interface PlayerService {
    Map<String, Object> get_rec_file(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> get_rec_files(Map<String, Object> map) throws Exception;
    Map<String, Object> get_rec_base64(Map<String, Object> map) throws Exception;

}
