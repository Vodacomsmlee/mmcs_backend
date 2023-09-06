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
    public Map<String, Object> account_total_cnt(Map<String, Object> map) {
        return acntDao.account_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> account_list(Map<String, Object> map) {
        return acntDao.account_list(map);
    }
    @Override
    public List<Map<String, Object>> account_dept_list(Map<String, Object> map) {
        return acntDao.account_dept_list(map);
    }
    @Override
    public int account_add(Map<String, Object> map) {
        return acntDao.account_add(map);
    }
    @Override
    public int account_edt(Map<String, Object> map) {
        return acntDao.account_edt(map);
    }
    @Override
    public int account_del(Map<String, Object> map) {
        return acntDao.account_del(map);
    }
}
