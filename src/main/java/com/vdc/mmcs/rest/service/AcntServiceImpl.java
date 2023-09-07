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

    /* account */

    @Override
    public Map<String, Object> account_total_cnt(Map<String, Object> map) {
        return acntDao.account_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> account_list(Map<String, Object> map) {
        return acntDao.account_list(map);
    }
    @Override
    public Map<String, Object> account_search_total_cnt(Map<String, Object> map) {
        return acntDao.account_search_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> account_search_list(Map<String, Object> map) {
        return acntDao.account_search_list(map);
    }
    @Override
    public List<Map<String, Object>> account_dept_list(Map<String, Object> map) {
        return acntDao.account_dept_list(map);
    }
    @Override
    public List<Map<String, Object>> account_info(Map<String, Object> map) {
        return acntDao.account_info(map);
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
    public int account_dept_edt(Map<String, Object> map) {
        return acntDao.account_dept_edt(map);
    }
    @Override
    public int account_del(Map<String, Object> map) {
        return acntDao.account_del(map);
    }

    /* dept */

    @Override
    public List<Map<String, Object>> dept_list(Map<String, Object> map) {
        return acntDao.dept_list(map);
    }
    @Override
    public List<Map<String, Object>> dept_info(Map<String, Object> map) {
        return acntDao.dept_info(map);
    }
    @Override
    public int dept_add(Map<String, Object> map) {
        return acntDao.dept_add(map);
    }
    @Override
    public int dept_edt(Map<String, Object> map) {
        return acntDao.dept_edt(map);
    }
    @Override
    public int dept_del(Map<String, Object> map) {
        return acntDao.dept_del(map);
    }
}
