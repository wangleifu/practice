package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/18 9:47
 */
public class No114_medium {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val=2;
        TreeNode node3 = new TreeNode();
        node3.val=3;
        TreeNode node4 = new TreeNode();
        node4.val=4;
        TreeNode node5 = new TreeNode();
        node5.val=5;
        TreeNode node6 = new TreeNode();
        node6.val=6;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        root.left = node2;
        root.right = node5;

        root.preOrder();
        root.inOrder();
        root.postOrder(root);


        No114_medium no114_medium = new No114_medium();
        no114_medium.flatten2(root);
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        TreeNode res = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (res == null) {
                res = root;
            } else {
                res.right = cur;
                res = res.right;
            }
            res.left = null;
            res.right = null;
        }
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                 while (pre.right != null) {
                     pre = pre.right;
                 }
                 pre.right = cur.right;
                 cur.right = next;
                 cur.left = null;
            }
            cur = cur.right;
        }
    }
}
