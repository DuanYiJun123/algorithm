/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:30 下午 2022/6/8
 **/


package org.example.linked;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);


    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        moveToTail(node);
        return node.value;
    }

    private void moveToTail(Node node) {
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
    }


    public void put(int key, int value) {
        int i = get(key);
        if (i != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
        }
        if (map.size() != capacity) {
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(1);
        System.out.println(i);
        lruCache.put(3, 3);
        int i1 = lruCache.get(2);
        System.out.println(i1);
    }

}
