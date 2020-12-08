package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/11 9:47
 */
public class No94_medium {
    public static void main(String[] args) {
        No94_medium no94 = new No94_medium();
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val=2;
        TreeNode right = new TreeNode();
        right.val=3;
//        root.left = left;
        root.right = right;
        right.left = left;
        System.out.println(no94.inorderTraversal2(root));
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        if (root.left != null) {
            resList.addAll(inorderTraversal(root.left));
        }
        resList.add(root.val);
        if (root.right != null) {
            resList.addAll(inorderTraversal(root.right));
        }

        return resList;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            resList.add(cur.val);
            cur = cur.right;
        }

        return resList;
    }

    /**
     *  前序遍历
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            resList.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return resList;
    }
}
