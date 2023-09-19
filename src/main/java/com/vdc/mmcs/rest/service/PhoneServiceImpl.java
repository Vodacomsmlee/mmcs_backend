package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.PhoneDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("phoneService")
public class PhoneServiceImpl implements PhoneService {

    @Resource(name="phoneDao")
    private PhoneDao phoneDao;

    /* group */

    @Override
    public Map<String, Object> group_list(Map<String, Object> map) {
        return phoneDao.group_list(map);
    }
    @Override
    public List<Map<String, Object>> group_info(Map<String, Object> map) {
        return phoneDao.group_info(map);
    }
    @Override
    public int group_add(Map<String, Object> map) {
        return phoneDao.group_add(map);
    }
    @Override
    public int group_edt(Map<String, Object> map) {
        return phoneDao.group_edt(map);
    }
    @Override
    public int group_del(Map<String, Object> map) {
        return phoneDao.group_del(map);
    }

    /* phone */

    @Override
    public List<Map<String, Object>> phone_list(Map<String, Object> map) {
        return phoneDao.phone_list(map);
    }
    @Override
    public Map<String, Object> phone_total_cnt(Map<String, Object> map) {
        return phoneDao.phone_total_cnt(map);
    }
    @Override
    public Map<String, Object> phone_search_total_cnt(Map<String, Object> map) {
        return phoneDao.phone_search_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> phone_search_list(Map<String, Object> map) {
        return phoneDao.phone_search_list(map);
    }
    @Override
    public int phone_add(Map<String, Object> map) {
        return phoneDao.phone_add(map);
    }
    @Override
    public int phone_edt(Map<String, Object> map) {
        return phoneDao.phone_edt(map);
    }
    @Override
    public int phone_del(Map<String, Object> map) {
        return phoneDao.phone_del(map);
    }

    @Override
    public List<Map<String, Object>> phone_group_list(Map<String, Object> map) {
        return phoneDao.phone_group_list(map);
    }
    @Override
    public Map<String, Object> phone_group_total_cnt(Map<String, Object> map) {
        return phoneDao.phone_group_total_cnt(map);
    }
    @Override
    public int phone_group_edt(Map<String, Object> map) {
        return phoneDao.phone_group_edt(map);
    }
}


