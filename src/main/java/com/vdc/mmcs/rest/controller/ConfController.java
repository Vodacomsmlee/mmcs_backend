package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.common.resolver.ReturnMap;
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
    public Map<String, Object> holiday_del(CommandMap commandMap) throws Exception {

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
}
