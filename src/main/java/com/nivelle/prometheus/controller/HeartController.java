package com.nivelle.prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2022/05/02
 */
@RequestMapping("/test")
public class HeartController {

    @RequestMapping(value = "/heart",method = RequestMethod.GET)
    @ResponseBody
    public String heart(String a) {
        return "hello heart:" + a;
    }
}
