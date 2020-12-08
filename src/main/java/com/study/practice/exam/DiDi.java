package com.study.practice.exam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/12/1 22:00
 */
public class DiDi {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(first(2, 1E-10));
        System.out.println(second(10, 100_000));
    }

    private static double first(double n, double exp) {
        double low = 0.0, up = n;
        while (up - low > exp) {
            double mid = (up + low) / 2;
            if (mid * mid < n) {
                low = mid;
            } else {
                up = mid;
            }
        }

        return low;
    }

    public static long second(int n, int target) throws InterruptedException {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        int split = target / n;
        for (int i = 0; i < n; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                int sum = 0;
                for (int j = finalI * split; j < (finalI +1)*split; j++) {
                    sum += j;
                }
                map.put(finalI, sum);
                System.out.println("Thread: " + finalI + " finish!");
            });
            executorService.execute(thread);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

        long ans = 0;
        for (Integer key :map.keySet()) {
            ans += map.get(key);
        }
        return ans;
    }
}
