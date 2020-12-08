package com.study.practice.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/23 20:23
 */
public class PacerHealth {

    public static void main(String[] args) {

        PacerHealth pacerHealth = new PacerHealth();
//        System.out.println(pacerHealth.solution1(null));
//        System.out.println(pacerHealth.solution1(new int[]{}));
//        System.out.println(pacerHealth.solution1(new int[]{4, 2, 5, 8 ,7 ,3,7}));
//        System.out.println(pacerHealth.solution1(new int[]{14, 21, 16, 35, 22}));
//        System.out.println(pacerHealth.solution1(new int[]{5,5,5,5,5,5}));

//        System.out.println(pacerHealth.solution2(5, new int[]{2,2,1,2}, new int[]{1,3,4,4}));
//        System.out.println(pacerHealth.solution2(3, new int[]{1}, new int[]{3}));
//        System.out.println(pacerHealth.solution2(4, new int[]{1,3}, new int[]{2,4}));
//        System.out.println(pacerHealth.solution2(0, new int[]{}, new int[]{}));


//        System.out.println(pacerHealth.solution3(null));
//        System.out.println(pacerHealth.solution3(new int[]{}));
//        System.out.println(pacerHealth.solution3(new int[]{2,1,1,3,2,1,1,3}));
//        System.out.println(pacerHealth.solution3(new int[]{7,3,7,3,1,3,4,1}));
//        System.out.println(pacerHealth.solution3(new int[]{7,5,2,7,2,7,4,7}));
    }

    public int solution1(int[] A) {
        if (A== null || A.length < 2) {
            return 0;
        }

        int ans = 0, n = A.length;
        boolean[] used = new boolean[n];
        int index = 0;
        while (!used[index]) {
            if (((A[index] + A[(index+1)%n]) & 1) == 0) {
                used[index]=true;
                used[(index+1)%n]=true;
                index++;
                ans++;
            }
            index++;
            index = index >= n ? index % n : index;
        }
        return ans;
    }

    public int solution2(int N, int[] A, int[] B) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            cntMap.put(A[i], cntMap.getOrDefault(A[i], 0) + 1);
            cntMap.put(B[i], cntMap.getOrDefault(B[i], 0) + 1);
        }

        cntMap = cntMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<Integer, Integer> resMap = new HashMap<>();
        int score = N;
        for ( Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            resMap.put(entry.getKey(), score--);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += resMap.get(A[i]) + resMap.get(B[i]);
        }

        return ans;
    }

    public int solution3(int[] A) {
        if (A== null || A.length == 0) {
            return 0;
        }


        Map<Integer, Integer> ori = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        // 初始化t串的哈希表：（字符，个数）
        for (int value : A) {
            ori.put(value, 1);
        }
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;
        int sLen = A.length;
        // 滑动窗口
        // 1. 右指针右移
        while (r < sLen) {
            // 右移cnt map计数增加
            cnt.put(A[r], cnt.getOrDefault(A[r], 0) + 1);
            // 2. 左指针右移
            while (check(ori, cnt) && l <= r) {
                //3. 更新结果区间
                if (r - l + 1 < len) {
                    len = r - l + 1;
                }
                // 左移cnt map计数减少
                cnt.put(A[l], cnt.getOrDefault(A[l], 0) - 1);
                ++l;
            }
            r++;
        }
        return len;
    }

    // 检查两个map是否相等
    public boolean check(Map<Integer, Integer> ori, Map<Integer, Integer> cnt) {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
