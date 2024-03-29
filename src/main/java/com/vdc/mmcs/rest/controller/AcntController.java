package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.rest.service.AcntService;
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
 *  account, dept
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Controller
public class AcntController {

    private final AcntService acntService;

    /* account */

    // account 목록 조회
    @RequestMapping(value="/account/list")
    @ResponseBody
    public Map<String, Object> account_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = acntService.account_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = acntService.account_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);

        return Map;
    }
    // account 검색 조회
    @RequestMapping(value="/account/srch/list")
    @ResponseBody
    public Map<String, Object> account_search_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = acntService.account_search_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = acntService.account_search_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);

        return Map;
    }
    // account 부서별 조회
    @RequestMapping(value="/account/dept/list")
    @ResponseBody
    public Map<String, Object> account_dept_list(CommandMap commandMap) throws Exception {

        Map<String, Object> TotalCnt = acntService.account_dept_total_cnt(commandMap.getMap());
        List<Map<String, Object>> ListMap = acntService.account_dept_list(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();

        Map.put("total", TotalCnt.get("cnt"));
        Map.put("rows", ListMap);
        return Map;
    }

    // account 상세 조회
    @RequestMapping(value="/account/info")
    @ResponseBody
    public Map<String, Object> account_info(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = acntService.account_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }

    // account 계정 추가
    @RequestMapping(value="/account/add")
    @ResponseBody
    public Map<String, Object> account_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.account_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // account 계정 수정
    @RequestMapping(value="/account/edt")
    @ResponseBody
    public Map<String, Object> account_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.account_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }

    // account 계정 부서만 수정
    @RequestMapping(value="/account/dept/edt")
    @ResponseBody
    public Map<String, Object> account_dept_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.account_dept_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }
    // account 계정 삭제
    @RequestMapping(value="/account/del")
    @ResponseBody
    public Map<String, Object> account_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.account_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }

        return Map;
    }


    /* dept */

    // 부서 목록
    @RequestMapping(value="/dept/list")
    @ResponseBody
    public String dept_list(CommandMap commandMap) throws Exception {

        Map<String, Object> rstMap = acntService.dept_list(commandMap.getMap());

        return rstMap.get("json").toString();

    }
    // 부서 정보
    @RequestMapping(value="/dept/info")
    @ResponseBody
    public Map<String, Object> dept_info(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = acntService.dept_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }
    // 부서 추가
    @RequestMapping(value="/dept/add")
    @ResponseBody
    public Map<String, Object> dept_add(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.dept_add(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // 부서 수정
    @RequestMapping(value="/dept/edt")
    @ResponseBody
    public Map<String, Object> dept_edt(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.dept_edt(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;

    }
    // 부서 삭제
    @RequestMapping(value="/dept/del")
    @ResponseBody
    public Map<String, Object> dept_del(CommandMap commandMap) {

        Map<String,Object> Map = new HashMap<>();

        try {
            acntService.dept_del(commandMap.getMap());
            Map.put("success", true);
        } catch (Exception e) {
            Map.put("success", false);
            Map.put("msg", e.getMessage());
        }
        return Map;
    }


}
