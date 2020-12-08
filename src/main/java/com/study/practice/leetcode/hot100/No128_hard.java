package com.study.practice.leetcode.hot100;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/24 9:49
 */
public class No128_hard {
    public static void main(String[] args) {
        No128_hard no128_hard = new No128_hard();
        System.out.println(no128_hard.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(no128_hard.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longestConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (numSet.contains(x-1)) {
                continue;
            }

            while (numSet.contains(++x));
            longestConsecutive =Math.max(longestConsecutive, x-nums[i]);
        }

        return longestConsecutive;
    }
}
