package com.nivelle.prometheus;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

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
        ReentrantLock lock = new ReentrantLock(true);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 30; i++) {
            try {
                pool.execute(new Task(String.valueOf(i), lock));
            } catch (Exception e) {

            }
        }


    }
}

class Task implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Task(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(this.name + "---运行的线程" + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

}
