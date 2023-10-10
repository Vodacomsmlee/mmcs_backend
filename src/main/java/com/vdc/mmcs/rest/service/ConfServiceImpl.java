package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.common.util.StringUtil;
import com.vdc.mmcs.rest.dao.ConfDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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


    /* conference */
    @Override
    public Map<String, Object> conference_total_cnt(Map<String, Object> map) {
        return confDao.conference_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> conference_list(Map<String, Object> map) {
        return confDao.conference_list(map);
    }
    @Override
    public List<Map<String, Object>> conference_info(Map<String, Object> map) {
        return confDao.conference_info(map);
    }
    @Override
    public List<Map<String, Object>> conference_info_tel_no(Map<String, Object> map) {
        return confDao.conference_info_tel_no(map);
    }
    @Override
    public int conference_add(Map<String, Object> map) {
        return confDao.conference_add(map);
    }
    @Override
    public int conference_edt(Map<String, Object> map) {
        return confDao.conference_edt(map);
    }
    @Override
    public int conference_del(Map<String, Object> map) {
        return confDao.conference_del(map);
    }


    /* attendant */
    @Override
    public List<Map<String, Object>> attendant_list(Map<String, Object> map) {
        return confDao.attendant_list(map);
    }
    @Override
    public int attendant_add(Map<String, Object> map) {
        return confDao.attendant_add(map);
    }
    @Override
    public int attendant_autocall_edt(Map<String, Object> map) {
        return confDao.attendant_autocall_edt(map);
    }
    @Override
    public int attendant_pin_edt(Map<String, Object> map) {
        return confDao.attendant_pin_edt(map);
    }
    @Override
    public int attendant_desc_edt(Map<String, Object> map) {
        return confDao.attendant_desc_edt(map);
    }
    @Override
    public int attendant_del(Map<String, Object> map) {
        return confDao.attendant_del(map);
    }


    /* conference_reserve */
    @Override
    public List<Map<String, Object>> reserve_all_list(Map<String, Object> map) {
        return confDao.reserve_all_list(map);
    }
    @Override
    public List<Map<String, Object>> reserve_list(Map<String, Object> map) {
        return confDao.reserve_list(map);
    }
    @Override
    public int reserve_add(Map<String, Object> map) {
        return confDao.reserve_add(map);
    }
    @Override
    public int reserve_edt(Map<String, Object> map) {
        return confDao.reserve_edt(map);
    }
    @Override
    public int reserve_del(Map<String, Object> map) {
        return confDao.reserve_del(map);
    }
    @Override
    public int reserve_pause(Map<String, Object> map) {
        return confDao.reserve_pause(map);
    }

    /* hist */
    @Override
    public Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) { return confDao.hist_rec_total_cnt(map); }
    @Override
    public List<Map<String, Object>> hist_rec_list(Map<String, Object> map) {
        return confDao.hist_rec_list(map);
    }
    @Override
    public int hist_rec_Add(Map<String, Object> map, HttpServletRequest request) {
        map.put("conn_ip", StringUtil.getClientIp(request));
        return confDao.hist_rec_Add(map);
    }

}
