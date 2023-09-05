package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.AcntDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("acntService")
public class AcntServiceImpl implements AcntService {

    @Resource(name="acntDao")
    private AcntDao acntDao;

    @Override
    public List<Map<String, Object>> account_list(Map<String, Object> map) {
        return acntDao.account_list(map);
    }
    @Override
    public List<Map<String, Object>> account_add(Map<String, Object> map) {
        return acntDao.account_add(map);
    }
    @Override
    public List<Map<String, Object>> account_edt(Map<String, Object> map) {
        return acntDao.account_edt(map);
    }
    @Override
    public List<Map<String, Object>> account_del(Map<String, Object> map) {
        return acntDao.account_del(map);
    }
}
