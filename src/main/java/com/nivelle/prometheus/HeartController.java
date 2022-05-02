package com.nivelle.prometheus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2022/05/02
 */
@RestController
public class HeartController {

    @RequestMapping("/heart")
    public String heart(String a) {
        return "hello heart:" + a;
    }
}
