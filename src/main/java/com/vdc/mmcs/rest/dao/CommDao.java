package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("commDao")
public class CommDao extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    public List<Map<String, Object>> montrn_channel(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "common.montrn_channel_list", map);
    }
    public List<Map<String, Object>> montrn_conference_info(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "common.montrn_conference_info", map);
    }
    public List<Map<String, Object>> comm_conference_stt(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "common.comm_conference_stt", map);
    }


    public List<Map<String, Object>> config_list(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "common.config_list", map);
    }
    public int config_add(Map<String, Object> map) {
        return (int) insert(sqlSession, "common.config_add", map);
    }
    public int config_edt(Map<String, Object> map) {
        return (int) update(sqlSession, "common.config_edt", map);
    }
    public int config_del(Map<String, Object> map) {
        return (int) update(sqlSession, "common.config_del", map);
    }

    // DISK 사용량을 위한 PATH 가져오기
    public Map<String, Object> get_rec_root_path(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "common.get_rec_root_path", map);
    }

}
