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

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> montrn_channel(Map<String, Object> map) {
        return (List<Map<String, Object>>)selectList(sqlSession, "common.montrn_channel_list", map);
    }

}
