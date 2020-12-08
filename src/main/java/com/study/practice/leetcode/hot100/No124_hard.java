package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/20 9:59
 */
public class No124_hard {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = -10;
        TreeNode left = new TreeNode();
        left.val = 9;
        TreeNode right1 = new TreeNode();
        right1.val = 20;
        TreeNode right2 = new TreeNode();
        right2.val = 15;
        TreeNode right3 = new TreeNode();
        right3.val = 7;

        root.left = left;
        root.right = right1;
        right1.left = right2;
        right1.right = right3;

        No124_hard no124_hard = new No124_hard();
        System.out.println(no124_hard.maxPathSum(root));
    }

    private static int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPath;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftRes = Math.max(maxGain(root.left), 0);
        int rightRes = Math.max(maxGain(root.right), 0);

        maxPath = Math.max(maxPath, root.val + leftRes + rightRes);
        return root.val + Math.max(leftRes, rightRes);
    }
}
