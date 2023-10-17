package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("playerDao")
public class PlayerDao extends AbstractDAO {
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    public Map<String, Object> get_rec_file(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "player.get_rec_file", map);
    }
    public List<Map<String, Object>> get_rec_files(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "player.get_rec_file", map);
    }
    public Map<String, Object> get_rec_base64(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "player.get_rec_file", map);
    }
}
