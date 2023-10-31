package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.common.util.StringUtil;
import com.vdc.mmcs.rest.dao.HistDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("histService")
public class HistServiceImpl implements HistService{

    @Resource(name="histDao")
    private HistDao histfDao;

    /* hist */
    @Override
    public Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) { return histfDao.hist_rec_total_cnt(map); }
    @Override
    public List<Map<String, Object>> hist_rec_list(Map<String, Object> map) {
        return histfDao.hist_rec_list(map);
    }
    @Override
    public int hist_rec_Add(Map<String, Object> map, HttpServletRequest request, HttpSession session) {
        map.put("_SESSION_USER_ID_", session.getAttribute("user_id"));
        map.put("conn_ip", StringUtil.getClientIp(request));
        return histfDao.hist_rec_Add(map);
    }
    @Override
    public List<Map<String, Object>> hist_conference_list(Map<String, Object> map) {
        return histfDao.hist_conference_list(map);
    }
    @Override
    public Map<String, Object> hist_conference_total_cnt(Map<String, Object> map) {
        return histfDao.hist_conference_total_cnt(map);
    }
    @Override
    public List<Map<String, Object>> hist_conference_attendant_list(Map<String, Object> map) {
        return histfDao.hist_conference_attendant_list(map);
    }
    @Override
    public List<Map<String, Object>> hist_conference_stt_list(Map<String, Object> map) {
        return histfDao.hist_conference_stt_list(map);
    }
}
