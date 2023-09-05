package com.vdc.mmcs.rest.controller;

import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.common.resolver.ReturnMap;
import com.vdc.mmcs.rest.service.RestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class RestController {

    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;

    @Resource(name="restService")
    private RestService restService;

    @RequestMapping(value="/common")
    @ResponseBody
    public Map<String,Object> get_common(CommandMap commandMap) throws Exception {

        List<Map<String, Object>> Map = restService.get_common(commandMap.getMap());
        return page.addMap("rows", Map);
    }

}
