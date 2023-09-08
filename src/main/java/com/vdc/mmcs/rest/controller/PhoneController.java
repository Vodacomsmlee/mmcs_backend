package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.common.resolver.ReturnMap;
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
    // 부서 목록
    @RequestMapping(value="/group/list")
    @ResponseBody
    public String group_list(CommandMap commandMap) throws Exception {

        Map<String, Object> rstMap = phoneService.group_list(commandMap.getMap());

        return rstMap.get("json").toString();

    }
    // 부서 정보
    @RequestMapping(value="/group/info")
    @ResponseBody
    public Map<String, Object> group_info(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = phoneService.group_info(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }
    // 부서 추가
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
    // 부서 수정
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
    // 부서 삭제
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
}
