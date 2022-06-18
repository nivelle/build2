package com.nivelle.prometheus.controller;


import org.springframework.stereotype.Controller;
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
@Controller
public class HeartController {

    @RequestMapping(value = "/heart", method = RequestMethod.GET)
    @ResponseBody
    public String heart(String a) {
        return "hello heart:" + a;
    }

    /**
     * http://39.105.201.242/api/encrypt?pasword=nivelle
     *
     * nginx配置   /etc/nginx/nginx.conf
     * @param pasword
     * @return
     */
    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    @ResponseBody
    public String encrypt(String pasword) {
        if (pasword.equals("nivelle")) {
            int pwd = 881224 + 911020;
            return String.valueOf(pwd);
        } else {
            return "fuck ";
        }
    }

}
