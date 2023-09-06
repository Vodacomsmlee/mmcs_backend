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
    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;
    @Resource(name="confService")
    private ConfService confService;
    @RequestMapping(value="/hday/list")
    @ResponseBody
    public Map<String, Object> holiday_list(CommandMap commandMap) throws Exception {
        List<Map<String, Object>> ListMap = confService.holiday_list(commandMap.getMap());
        Map<String,Object> Map = new HashMap<>();
        Map.put("rows", ListMap);
        return Map;
    }

    @RequestMapping(value="/hday/add")
    @ResponseBody
    public Map<String, Object> holiday_add(CommandMap commandMap) throws Exception {
        int rst = confService.holiday_add(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;

    }

    @RequestMapping(value="/hday/edt")
    @ResponseBody
    public Map<String, Object> holiday_edt(CommandMap commandMap) throws Exception {
        int rst = confService.holiday_edt(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;
    }

    @RequestMapping(value="/hday/del")
    @ResponseBody
    public Map<String, Object> holiday_del(CommandMap commandMap) throws Exception {
        int rst = confService.holiday_del(commandMap.getMap());

        Map<String,Object> Map = new HashMap<>();
        Map.put("success", rst);
        return Map;
    }
}
