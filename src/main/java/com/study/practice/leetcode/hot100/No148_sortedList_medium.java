package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.ListNode;

import java.util.List;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/30 9:59
 */
public class No148_sortedList_medium {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node7.next = node5;
        node5.next = node2;
        node2.next = node3;

        No148_sortedList_medium no148 = new No148_sortedList_medium();
        no148.sortList(node7).print();
    }

    public ListNode sortList(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            ++length;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode pre = dummyHead, cur = dummyHead.next;
            while (cur != null) {
                ListNode leftHead = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode rightHead = cur.next;
                cur.next = null;

                cur = rightHead;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                    cur = next;
                }

                pre.next = merge(leftHead, rightHead);
                while (pre .next != null) {
                    pre = pre.next;
                }
            }
        }

        return dummyHead.next;
    }

    private ListNode  merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curNode.next = l;
                l = l.next;
            } else {
                curNode.next = r;
                r = r.next;
            }
            curNode =  curNode.next;
        }

        if (l != null) {
            curNode.next = l;
        } else if (r != null){
            curNode.next = r;
        }

        return dummyHead.next;
    }

}
