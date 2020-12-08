package com.study.practice.leetcode.hot100;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/20 9:49
 */
public class No121_easy {
    public static void main(String[] args) {
        No121_easy no121_easy = new No121_easy();
        System.out.println(no121_easy.maxProfit(new int[]{}));
        System.out.println(no121_easy.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(no121_easy.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int ans = 0, maxPrice = prices[prices.length-1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (maxPrice > prices[i]) {
                ans = Math.max(ans, maxPrice - prices[i]);
            } else {
                maxPrice = prices[i];
            }
        }

        return ans;
    }
}
