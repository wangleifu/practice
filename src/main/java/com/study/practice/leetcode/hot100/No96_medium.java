package com.study.practice.leetcode.hot100;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/12 9:51
 */
public class No96_medium {
    public static void main(String[] args) {
        No96_medium no96 = new No96_medium();
        System.out.println(no96.catalan(3));
        System.out.println(no96.catalan(4));
    }

    public int numTrees(int n) {
        int[] fn = new int[n+1];

        fn[0] = 1;
        fn[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                fn[i] += fn[j]*fn[i-j-1];
            }
        }

        return fn[n];
    }


    public int catalan(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2*i+1) / (i+2);
        }

        return (int) C;
    }
}
