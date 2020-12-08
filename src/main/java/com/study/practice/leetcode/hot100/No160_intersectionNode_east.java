package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.ListNode;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/12/7 9:44
 */
public class No160_intersectionNode_east {

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

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node7.next = node8;
        node8.next = node9;
        node9.next = node2;


        No160_intersectionNode_east no160 = new No160_intersectionNode_east();
        no160.getIntersectionNode1(node1, node7).print();
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        ListNode cur = headA;
        while (cur != null) {
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        while (cur != null) {
            cur = cur.next;
            lenB++;
        }

        ListNode tempA = headA, tempB = headB;
        while (lenA > lenB) {
            tempA = tempA.next;
            lenA--;
        }
        while (lenB > lenA) {
            tempB = tempB.next;
            lenB--;
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}
