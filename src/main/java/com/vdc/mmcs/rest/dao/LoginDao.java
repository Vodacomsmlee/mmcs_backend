package com.vdc.mmcs.rest.dao;

import com.vdc.mmcs.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository("loginDao")
public class LoginDao extends AbstractDAO {
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    public Map<String, Object> account_login(Map<String, Object> map) {
        return (Map<String, Object>)selectOne(sqlSession, "login.account_login", map);
    }
    public int account_last_login(Map<String, Object> map) {
        return (int) update(sqlSession, "login.account_last_login", map);
    }
}
