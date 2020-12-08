package com.study.practice.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/26 10:05
 */
public class No146_LRCCache_medium {
    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private DLinkedNode head, tail;

    public No146_LRCCache_medium(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            node.value = value;

        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);

            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail);
                size--;
            }
        }


    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
