package com.vdc.mmcs.rest.controller;

import com.vdc.mmcs.common.resolver.ReturnMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;

/**
 * 녹취이력, 회의실 통화이력, 참석자 통화이력
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HistController {
    /** view page return map **/
    @Resource(name="returnMap")
    private ReturnMap page;

}
