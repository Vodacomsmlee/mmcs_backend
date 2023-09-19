package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * group, phone_book
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class PhoneController {
    @Resource(name="phoneService")
    private PhoneService phoneService;

    /* group */
    // 그룹 목록
    @RequestMapping(value="/group/list")
    @ResponseBody
    public String group_list(CommandMap commandMap) throws Exception {

        Map<String, Object> rstMap = phoneService.group_list(commandMap.getMap());

        return rstMap.get("json").toString();

    }
    // 그룹 정보
    @RequestMapping(value="/group/info")
    @ResponseBody
    public Map<String, Object> group_info(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = phoneService.group_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }
    // 그룹 추가
    @RequestMapping(value="/group/add")
    @ResponseBody
    public Map<String, Object> dept_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.group_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // 그룹 수정
    @RequestMapping(value="/group/edt")
    @ResponseBody
    public Map<String, Object> group_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.group_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // 그룹 삭제
    @RequestMapping(value="/group/del")
    @ResponseBody
    public Map<String, Object> group_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.group_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }

    /* 전화번호 */
    // 전화번호 목록
    @RequestMapping(value="/phone_book/list")
    @ResponseBody
    public Map<String, Object> phone_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = phoneService.phone_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = phoneService.phone_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }

    // 전화번호 검색 조회
    @RequestMapping(value="/phone_book/srch/list")
    @ResponseBody
    public Map<String, Object> phone_search_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = phoneService.phone_search_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = phoneService.phone_search_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);

        return Map;
    }

    // 전화번호 추가
    @RequestMapping(value="/phone_book/add")
    @ResponseBody
    public Map<String, Object> phone_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.phone_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // 전화번호 수정
    @RequestMapping(value="/phone_book/edt")
    @ResponseBody
    public Map<String, Object> phone_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.phone_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }
    // 전화번호 삭제
    @RequestMapping(value="/phone_book/del")
    @ResponseBody
    public Map<String, Object> phone_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.phone_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }

    // 그룹별 전화번호 목록 조회
    @RequestMapping(value="/phone_book/group/list")
    @ResponseBody
    public Map<String, Object> phone_group_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = phoneService.phone_group_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = phoneService.phone_group_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }


    // 전화번호 그룹만 수정
    @RequestMapping(value="/phone_book/group/edt")
    @ResponseBody
    public Map<String, Object> phone_group_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            phoneService.phone_group_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

}
