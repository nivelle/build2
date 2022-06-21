package com.nivelle.prometheus;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2022/06/21
 */
@Component
public class ScheduleJob {
    public int a = 0;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void myJob() {
        List<Integer> list = new ArrayList<>(128);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println("当前list 元素个数：" + list.size());
        if (list.size() > 50000) {
            list.clear();
            list = null;
            System.out.println("清空一次集合");
        }
        System.out.println("end =====");
    }
}
