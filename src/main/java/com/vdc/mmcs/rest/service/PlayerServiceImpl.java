package com.vdc.mmcs.rest.service;

import com.vdc.mmcs.rest.dao.PlayerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    @Resource(name="playerDao")
    private PlayerDao playerDao;

    @Override
    public Map<String, Object> get_rec_file(Map<String, Object> map) {
        return playerDao.get_rec_file(map);
    }
    @Override
    public List<Map<String, Object>> get_rec_files(Map<String, Object> map) {
        return playerDao.get_rec_files(map);
    }
    public Map<String, Object> get_rec_base64(Map<String, Object> map) {
        return playerDao.get_rec_base64(map);
    }

    @Override
    public List<Map<String, Object>> get_rec_file_info(Map<String, Object> map) {
        return playerDao.get_rec_file_info(map);
    }
}
