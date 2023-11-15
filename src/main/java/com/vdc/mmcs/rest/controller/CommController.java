package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.CommService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 공통
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class CommController {

    private final CommService commService;

    //채널 모니터링 조회
    @RequestMapping(value="/monitoring/channel")
    @ResponseBody
    public Map<String, Object> montrn_channel(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = commService.montrn_channel(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();

        Map.put("rows", ListMap);

        return Map;
    }
    @RequestMapping(value="/monitoring/conference")
    @ResponseBody
    public Map<String, Object> montrn_conference_info(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = commService.montrn_conference_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();

        Map.put("rows", ListMap);

        return Map;
    }

    @RequestMapping(value="/comm/conference/stt")
    @ResponseBody
    public Map<String, Object> comm_conference_stt(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = commService.comm_conference_stt(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();

        Map.put("rows", ListMap);

        return Map;
    }


}
