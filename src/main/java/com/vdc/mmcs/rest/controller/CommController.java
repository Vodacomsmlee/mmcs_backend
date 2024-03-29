package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.CommService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
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

    //설정
    @RequestMapping(value="/config/list")
    @ResponseBody
    public Map<String, Object> config_list(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = commService.config_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);

        return Map;
    }
    @RequestMapping(value="/config/add")
    @ResponseBody
    public Map<String, Object> config_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            commService.config_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }
    @RequestMapping(value="/config/edt")
    @ResponseBody
    public Map<String, Object> config_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            commService.config_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    @RequestMapping(value="/config/del")
    @ResponseBody
    public Map<String, Object> config_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            commService.config_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

    //DISK 사용량
    @RequestMapping(value="/system/disk")
    @ResponseBody
    public Map<String, Object> system_disk(CommandMap commandMap) {

        String dir_path = "";
        double totalSize, freeSize, useSize;
        Map<String,Object> Map = new HashMap<>();

        try {

            Map<String,Object> rstMap =  commService.get_rec_root_path(commandMap.getMap());
            dir_path = rstMap.get("val").toString();
            File rec_path = new File(dir_path);

            totalSize = rec_path.getTotalSpace() / Math.pow(1024, 2);
            useSize = rec_path.getUsableSpace() / Math.pow(1024, 2);
            freeSize = totalSize - useSize;

            Map.put("success", true);
            Map.put("Total", totalSize);
            Map.put("Used", freeSize);
            Map.put("Available", useSize);

        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }
}
