package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.ConfService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * conference, conference_reserve, attendant, holiday
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class ConfController {

    @Resource(name="confService")
    private ConfService confService;
    @RequestMapping(value="/holiday/list")
    @ResponseBody
    public Map<String, Object> holiday_list(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = confService.holiday_list(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }

    @RequestMapping(value="/holiday/add")
    @ResponseBody
    public Map<String, Object> holiday_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.holiday_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }

    @RequestMapping(value="/holiday/edt")
    @ResponseBody
    public Map<String, Object> holiday_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.holiday_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }

    @RequestMapping(value="/holiday/del")
    @ResponseBody
    public Map<String, Object> holiday_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.holiday_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }



    /* conference */

    @RequestMapping(value="/conference/list")
    @ResponseBody
    public Map<String, Object> conference_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = confService.conference_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = confService.conference_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);

        return Map;
    }

    @RequestMapping(value="/conference/info")
    @ResponseBody
    public Map<String, Object> conference_info(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = confService.conference_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }

    // 회의실 전화번호 검색
    @RequestMapping(value="/conference/info/tel")
    @ResponseBody
    public Map<String, Object> conference_info_tel_no(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = confService.conference_info_tel_no(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }


    @RequestMapping(value="/conference/add")
    @ResponseBody
    public Map<String, Object> conference_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.conference_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }

    @RequestMapping(value="/conference/edt")
    @ResponseBody
    public Map<String, Object> conference_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.conference_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

    @RequestMapping(value="/conference/del")
    @ResponseBody
    public Map<String, Object> conference_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.conference_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }


    /* attendant */
    @RequestMapping(value="/attendant/list")
    @ResponseBody
    public Map<String, Object> attendant_list(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = confService.attendant_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);

        return Map;
    }
    @RequestMapping(value="/attendant/add")
    @ResponseBody
    public Map<String, Object> attendant_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.attendant_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }
    @RequestMapping(value="/attendant/autocall/edt")
    @ResponseBody
    public Map<String, Object> attendant_autocall_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.attendant_autocall_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    @RequestMapping(value="/attendant/pin/edt")
    @ResponseBody
    public Map<String, Object> attendant_pin_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.attendant_pin_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    @RequestMapping(value="/attendant/desc/edt")
    @ResponseBody
    public Map<String, Object> attendant_desc_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.attendant_desc_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    @RequestMapping(value="/attendant/del")
    @ResponseBody
    public Map<String, Object> attendant_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.attendant_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }


    /* conference_reserve */
    @RequestMapping(value="/reserve/all/list")
    @ResponseBody
    public Map<String, Object> reserve_all_list(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = confService.reserve_all_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);

        return Map;
    }
    @RequestMapping(value="/reserve/list")
    @ResponseBody
    public Map<String, Object> reserve_list(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> ListMap = confService.reserve_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);

        return Map;
    }
    @RequestMapping(value="/reserve/add")
    @ResponseBody
    public Map<String, Object> reserve_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.reserve_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }
    @RequestMapping(value="/reserve/edt")
    @ResponseBody
    public Map<String, Object> reserve_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.reserve_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    @RequestMapping(value="/reserve/del")
    @ResponseBody
    public Map<String, Object> reserve_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.reserve_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

    // 예약 중지
    @RequestMapping(value="/reserve/pause")
    @ResponseBody
    public Map<String, Object> reserve_skip(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            confService.reserve_pause(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

}
