package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.ReturnMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;

/**
 * conference, conference_reserve, attendant, holiday
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class ConfController {
    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;

}
