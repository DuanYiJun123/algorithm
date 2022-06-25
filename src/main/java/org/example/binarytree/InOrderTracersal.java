/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:31 下午 2022/6/11
 **/


package org.example.binarytree;

import java.util.Stack;

/**
 * 中序遍历  左 本身 右
 */
public class InOrderTracersal {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node init() {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        return head;
    }

    public void solution(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    public void solution3(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        InOrderTracersal inOrderTracersal = new InOrderTracersal();
        Node head = inOrderTracersal.init();
        //inOrderTracersal.solution(head);
        inOrderTracersal.solution3(head);
    }
}
