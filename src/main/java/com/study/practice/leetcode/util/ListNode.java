package com.study.practice.leetcode.util;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/25 10:55
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
        ListNode node = this;

        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        sb.append("NULL");

        System.out.println(sb.toString());
    }
}
