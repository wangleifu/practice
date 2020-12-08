package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.ListNode;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/12/2 10:37
 */
public class No206_revertList_easy {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        No206_revertList_easy no206 = new No206_revertList_easy();
//        no206.reverseList(node1).print();
//        no206.reverseList2(node1).print();
        no206.reverseKList(node1, 1).print();
    }

    /*1.迭代翻转链表*/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /*2.递归翻转链表*/
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /*3.K个一组翻转链表*/
    public ListNode reverseKList(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode hair = new ListNode(-1);
        hair.next = head;

        ListNode pre = hair, start = head, end;
        while (start != null) {
            end = start;
            int count = 0;
            while (end != null && ++count != k) {end = end.next;}
            if (count == k) {
               reverse(start, end);
               pre.next = end;
               pre = start;
               start = start.next;
            } else {
                break;
            }
        }

        return hair.next;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next, p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }

        return tail;
    }
}
