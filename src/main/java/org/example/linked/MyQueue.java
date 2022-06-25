/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:28 下午 2022/6/13
 **/


package org.example.linked;

/**
 * 用单链表实现队列
 */
public class MyQueue {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void offer(int i) {
        Node node = new Node(i);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int poll() {
        if (head == null) {
            tail = null;
            return -1;
        }
        Node result = head;
        head = head.next;
        size--;
        return result.data;
    }

    public Node peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.size);
    }
}
