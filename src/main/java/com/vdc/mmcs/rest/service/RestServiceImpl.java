package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.RestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("restService")
public class RestServiceImpl implements RestService {

    @Resource(name="restDao")
    private RestDao restDao;

    @Override
    public List<Map<String, Object>> get_common(Map<String, Object> map) {
        return restDao.get_common(map);
    }
}
