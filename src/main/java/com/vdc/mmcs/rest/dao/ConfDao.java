package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("confDao")
public class ConfDao extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    public List<Map<String, Object>> holiday_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.holiday_list", map);
    }
    public int holiday_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "conf.holiday_add", map);
    }
    public int holiday_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.holiday_edt", map);
    }
    public int holiday_del(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.holiday_del", map);
    }


    /* conference */
    public Map<String, Object> conference_total_cnt(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "conf.conference_total_cnt", map);
    }
    public List<Map<String, Object>> conference_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.conference_list", map);
    }
    public List<Map<String, Object>> conference_info(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.conference_info", map);
    }
    public List<Map<String, Object>> conference_info_tel_no(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.conference_info_tel_no", map);
    }
    public int conference_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "conf.conference_add", map);
    }
    public int conference_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.conference_edt", map);
    }
    public int conference_del(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.conference_del", map);
    }


    /* attendant */
    public List<Map<String, Object>> attendant_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.attendant_list", map);
    }
    public int attendant_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "conf.attendant_add", map);
    }
    public int attendant_autocall_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.attendant_autocall_edt", map);
    }
    public int attendant_pin_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.attendant_pin_edt", map);
    }
    public int attendant_desc_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.attendant_desc_edt", map);
    }
    public int attendant_del(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.attendant_del", map);
    }

    /* conference_reserve */
    public List<Map<String, Object>> reserve_all_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.reserve_all_list", map);
    }
    public List<Map<String, Object>> reserve_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.reserve_list", map);
    }
    public int reserve_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "conf.reserve_add", map);
    }
    public int reserve_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.reserve_edt", map);
    }
    public int reserve_del(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.reserve_del", map);
    }
    public int reserve_pause(Map<String, Object> map) {
        return (int) update(sqlSession, "conf.reserve_pause", map);
    }

    /* hist */
    public Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "conf.hist_rec_total_cnt", map);
    }
    public List<Map<String, Object>> hist_rec_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "conf.hist_rec_list", map);
    }
    public int hist_rec_Add(Map<String, Object> map) {
        return (int) insert(sqlSession, "conf.hist_rec_Add", map);
    }

}
