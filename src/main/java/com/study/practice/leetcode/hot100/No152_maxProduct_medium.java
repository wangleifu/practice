package com.study.practice.leetcode.hot100;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/12/2 10:13
 */
public class No152_maxProduct_medium {
    public static void main(String[] args) {
        No152_maxProduct_medium no152 = new No152_maxProduct_medium();
        System.out.println(no152.maxProduct(new int[]{-1, 0, 2, 3, 4, 0, -4, -8}));
        System.out.println(no152.maxProduct(new int[]{-1, 0, 2, 3, 4, 0, -4, -8}));
    }

    public int maxProduct(int[] nums) {
        int ans = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = 0;
                min = 0;
            } else {
                int a = nums[i]*max;
                int b = nums[i]*min;
                max = Math.max(nums[i], Math.max(a, b));
                min = Math.min(nums[i], Math.min(a, b));
            }

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }
}
