package com.study.practice.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/11 9:47
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
       this.left = left;
         this.right = right;
    }

    public TreeNode createTree(int[] values) {
        TreeNode root = new TreeNode();

        TreeNode cur = root;
        for (int i = 0; i < values.length; i++) {

        }


        return root;
    }

    public void preOrder() {
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        TreeNode cur;
        sb.append("[");
        while (!stack.isEmpty()) {
            cur = stack.pop();
            sb.append(cur.val).append(",");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
        sb.deleteCharAt(sb.length()-1).append("]");
        System.out.println(sb.toString());
    }

    public void inOrder() {
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = this;
        sb.append("[");
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            sb.append(cur.val).append(",");
            cur =cur.right;

        }
        sb.deleteCharAt(sb.length()-1).append("]");

        System.out.println(sb.toString());
    }

    public void postOrder(TreeNode root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.val + ",");
    }
}
