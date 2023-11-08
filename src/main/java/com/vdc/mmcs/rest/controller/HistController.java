package com.vdc.mmcs.rest.controller;

import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.HistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 녹취이력, 회의실 통화이력, 참석자 통화이력, 통계
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HistController {
    @Resource(name="histService")
    private HistService histService;
    // 회의실 녹취 이력 목록
    @RequestMapping(value="/hist/rec/list")
    @ResponseBody
    public Map<String, Object> hist_rec_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = histService.hist_rec_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = histService.hist_rec_list(commandMap.getMap());

        Map<String, Object> Map = new HashMap<>();
        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }
    @RequestMapping(value="/hist/rec/add")
    @ResponseBody
    public Map<String, Object> hist_rec_Add(CommandMap commandMap, HttpServletRequest request, HttpSession session) {

        Map<String,Object> Map = new HashMap<>();

        try {
            histService.hist_rec_Add(commandMap.getMap(), request, session);
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }

    @RequestMapping(value="/hist/conference/list")
    @ResponseBody
    public Map<String, Object> hist_conference_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = histService.hist_conference_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = histService.hist_conference_list(commandMap.getMap());

        Map<String, Object> Map = new HashMap<>();
        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }
    @RequestMapping(value="/hist/conference/attendant/list")
    @ResponseBody
    public Map<String, Object> hist_conference_attendant_list(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = histService.hist_conference_attendant_list(commandMap.getMap());

        Map<String, Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }

    @RequestMapping(value="/hist/conference/stt/list")
    @ResponseBody
    public Map<String, Object> hist_stt_list(CommandMap commandMap) throws Exception {
        Map<String, Object> TotalCnt = histService.hist_conference_stt_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = histService.hist_conference_stt_list(commandMap.getMap());

        Map<String, Object> Map = new HashMap<>();
        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }
    }
