package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.common.resolver.ReturnMap;
import com.vdc.mmcs.rest.service.AcntService;
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
@Controller
public class AcntController {
    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;

    @Resource(name="acntService")
    private AcntService acntService;

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
    // account 부서별 조회
    @RequestMapping(value="/account/dept/list")
    @ResponseBody
    public Map<String, Object> account_dept_list(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = acntService.account_dept_list(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }




    // account 계정 추가
    @RequestMapping(value="/account/add")
    @ResponseBody
    public Map<String, Object> account_add(CommandMap commandMap) throws Exception {
        int rst = acntService.account_add(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;

    }
    // account 계정 수정
    @RequestMapping(value="/account/edt")
    @ResponseBody
    public Map<String, Object> account_edt(CommandMap commandMap) throws Exception {
        int rst = acntService.account_edt(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;
    }
    // account 계정 삭제
    @RequestMapping(value="/account/del")
    @ResponseBody
    public Map<String, Object> account_del(CommandMap commandMap) throws Exception {
        int rst = acntService.account_del(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;
    }

}
