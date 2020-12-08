package com.study.practice.leetcode.hot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/9 9:47
 */
public class No84_hard {

    public static void main(String[] args) {
        No84_hard no84 = new No84_hard();
        System.out.println(no84.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
        System.out.println(no84.largestRectangleArea2(new int[]{4,2,0,3,2,4,3,4}));
        System.out.println(no84.largestRectangleArea3(new int[]{4,2,0,3,2,4,3,4}));
    }

    /**
     * 暴力枚举，空间&时间复杂度都是O(N2)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            while (left -1 >= 0 && heights[left-1] >= heights[i]) left--;

            int right = i;
            while (right+1 < heights.length && heights[right+1] >= heights[i]) right++;

            int area = (right - left + 1) * heights[i];

            if (area > maxArea) {
                maxArea = area;
                System.out.println("i: " +i + " left: " + left + " right: " + right);
            }
        }

        return maxArea;
    }

    /**
     * 单调栈，空间&时间复杂度都是O(N)
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int n = heights.length;
        int[] lefts = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] rights = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            rights[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int area = (rights[i] - lefts[i] - 1) * heights[i];

            ans = Math.max(area, ans);
        }

        return ans;
    }

    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        int n = heights.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        Arrays.fill(rights, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rights[stack.peek()] = i;
                stack.pop();
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int area = (rights[i] - lefts[i] - 1) * heights[i];

            ans = Math.max(area, ans);
        }

        return ans;
    }
}
