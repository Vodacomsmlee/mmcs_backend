package com.vdc.mmcs.rest.controller;


import com.vdc.mmcs.common.resolver.ReturnMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;

/**
 * group, phone_book
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class PhoneController {
    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;

}
