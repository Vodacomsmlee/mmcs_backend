package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("taskDao")
public class TaskDao extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    public void channel(Map<String, Object> map) {
        insert(sqlSession, "task.channel", map);
    }

    public List<Map<String, Object>> conference(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "task.conference_reserve", map);
    }
    public List<Map<String, Object>> attendant(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "task.conference_reserve_attendant", map);
    }

    public int conference_reserve_next_dt(Map<String, Object> map) {
        return (int) update(sqlSession, "task.conference_reserve_next_dt", map);
    }
}
