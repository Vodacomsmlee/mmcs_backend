package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("acntDao")
public class AcntDao extends AbstractDAO {
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;


    public Map<String, Object> account_total_cnt(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "acnt.account_total_cnt", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> account_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.account_list", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> account_dept_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.account_dept_list", map);
    }
    public int account_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "acnt.account_add", map);
    }
    public int account_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "acnt.account_edt", map);
    }
    public int account_del(Map<String, Object> map) {
        return (int) update(sqlSession, "acnt.account_del", map);
    }
}
