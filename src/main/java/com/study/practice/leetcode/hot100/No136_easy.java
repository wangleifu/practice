package com.study.practice.leetcode.hot100;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/25 9:54
 */
public class No136_easy {
    public static void main(String[] args) {
        No136_easy no136_easy = new No136_easy();
        System.out.println(no136_easy.singleNumber(new int[]{1, 2, 2}));
        System.out.println(no136_easy.singleNumber(new int[]{4, 1, 1, 2, 2}));
        no136_easy.swap(1, 2);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public void swap(int a, int b) {
        System.out.println("swap: ");
        System.out.println("    before: a=" + a + ", b=" + b);
        if (a != b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }

        System.out.println("    after:  a=" + a + ", b=" + b);
    }
}
