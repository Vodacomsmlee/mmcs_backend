package com.vdc.mmcs.rest.service;

import java.util.Map;

public interface LoginService {

    Map<String, Object> account_login(Map<String, Object> map) throws Exception;
    int account_last_login(Map<String, Object> map) throws Exception;

}
