package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.ConfDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("confService")
public class ConfServiceImpl implements ConfService{

    @Resource(name="confDao")
    private ConfDao confDao;

    @Override
    public List<Map<String, Object>> holiday_list(Map<String, Object> map) {
        return confDao.holiday_list(map);
    }
    @Override
    public int holiday_add(Map<String, Object> map) {
        return confDao.holiday_add(map);
    }
    @Override
    public int holiday_edt(Map<String, Object> map) {
        return confDao.holiday_edt(map);
    }
    @Override
    public int holiday_del(Map<String, Object> map) {
        return confDao.holiday_del(map);
    }
}
