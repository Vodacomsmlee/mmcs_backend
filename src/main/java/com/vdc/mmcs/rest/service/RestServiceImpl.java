package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.RestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("restService")
public class RestServiceImpl implements RestService {

    @Resource(name="restDao")
    private RestDao restDao;

}
