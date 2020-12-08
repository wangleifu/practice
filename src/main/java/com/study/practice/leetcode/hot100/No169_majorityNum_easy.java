package com.study.practice.leetcode.hot100;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/12/7 10:15
 */
public class No169_majorityNum_easy {
    public static void main(String[] args) {
        No169_majorityNum_easy no169 = new No169_majorityNum_easy();
        System.out.println(no169.majorityElement(new int[]{3, 2, 3}));
        System.out.println(no169.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    /**
     * 摩尔投票法
     */
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count =1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ans) {
                count--;
                if (count == 0) {
                    count = 1;
                    ans = nums[i];
                }
            } else {
                count++;
            }
        }

        return ans;
    }
}
