package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("histDao")
public class HistDao extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    /* hist */
    public Map<String, Object> hist_rec_total_cnt(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "hist.hist_rec_total_cnt", map);
    }
    public List<Map<String, Object>> hist_rec_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "hist.hist_rec_list", map);
    }
    public int hist_rec_Add(Map<String, Object> map) {
        return (int) insert(sqlSession, "hist.hist_rec_Add", map);
    }
    public List<Map<String, Object>> hist_conference_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "hist.hist_conference_list", map);
    }
    public Map<String, Object> hist_conference_total_cnt(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "hist.hist_conference_total_cnt", map);
    }
    public List<Map<String, Object>> hist_conference_attendant_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "hist.hist_conference_attendant_list", map);
    }
    public List<Map<String, Object>> hist_conference_stt_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "hist.hist_conference_stt_list", map);
    }
}
