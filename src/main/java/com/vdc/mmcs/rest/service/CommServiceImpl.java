package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.CommDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("commService")
public class CommServiceImpl implements CommService{

    @Resource(name="commDao")
    private CommDao commDao;

    @Override
    public List<Map<String, Object>> montrn_channel(Map<String, Object> map) {
        return commDao.montrn_channel(map);
    }
    @Override
    public List<Map<String, Object>> montrn_conference_info(Map<String, Object> map) {
        return commDao.montrn_conference_info(map);
    }
    @Override
    public Map<String, Object> montrn_conference_total_cnt(Map<String, Object> map) {
        return commDao.montrn_conference_total_cnt(map);
    }
}
