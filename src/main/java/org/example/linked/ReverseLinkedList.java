/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:56 下午 2022/6/7
 **/


package org.example.linked;

public class ReverseLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 初始化链表
     *
     * @return
     */
    public static Node init() {
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node0;
    }

    public static void showList(Node head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node reverse1(Node head) {
        if (head == null) {
            return null;
        }
        // Node dummy = new Node(-1);
        // dummy.next = head;
        Node prev = head;
        Node current = prev.next;
        head.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node reverse2(Node head, int m, int n) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prevN = head;
        for (int i = 1; i < m - 1; i++) {
            prevN = prevN.next;
        }
        Node mNode = prevN.next;
        Node nNode = mNode;
        Node postM = mNode.next;
        for (int i = m; i < n; i++) {
            Node next = postM.next;
            postM.next = mNode;
            mNode = postM;
            postM = next;
        }
        prevN.next = mNode;
        nNode.next = postM;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = init();
//        Node reverse = reverse1(head);
//        showList(reverse);
        // Node node = reverse2(head, 1, 4);
        Node node = reverse1(head);
        showList(node);
    }
}
