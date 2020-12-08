package com.study.practice.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/12 18:15
 */
public class MapPractice {

    public static void main(String[] args) throws InterruptedException {
//        hashMap();
        foreach();
        System.out.println(Long.MAX_VALUE);
    }

    private static void hashMap() throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                map.put(UUID.randomUUID().toString(), 0);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 10000; i < 20000; i++) {
                map.put(UUID.randomUUID().toString(), 0);
            }
        });
        thread2.start();

        System.out.println(map.get("wangleifu"));

        Thread.sleep(5 * 1000);
        System.out.println(map.size());
    }

    private static Map<Integer, Integer> map = null;
    private static void foreach() {
        Map<Integer, Integer> temp1 = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            temp1.put(i, i);
        }

        Map<Integer, Integer> temp2 = new HashMap<>();
        for (int i = 200; i < 360; i++) {
            temp2.put(i, i);
        }

        map = temp1;
        Thread thread1 = new Thread(() -> {
            map.forEach((key, value) -> {System.out.println("Thread1:\t" + "Thread: " + Thread.currentThread().getName() + "\t" + key + "\t" + value + "\tsize: " + map.size());});
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                System.out.println("Thread: " + Thread.currentThread().getName() + "\t" + entry.getKey() + "\t" + entry.getValue() + "\tsize: " + map.size());
//            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 111; i < 200; i++) {
                if (i == 150) {
                    map = temp2;
//                    map.forEach((key, value) -> {System.out.println("Thread2:\t" + "Thread: " + Thread.currentThread().getName() + "\t" + key + "\t" + value + "\tsize: " + map.size());});
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        System.out.println("Thread: " + Thread.currentThread().getName() + "\t" + entry.getKey() + "\t" + entry.getValue());
                    }
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + "\t" + i);
            }
        });

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.execute(thread1);
        fixedThreadPool.execute(thread2);
        fixedThreadPool.shutdown();
        thread1.start();

    }
}
