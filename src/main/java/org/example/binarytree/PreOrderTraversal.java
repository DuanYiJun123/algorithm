/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:29 下午 2022/6/11
 **/


package org.example.binarytree;

import java.util.Stack;

/**
 * 前序遍历，自己 左 右； 非递归最简单
 *
 * 1、无脑进栈
 * 2、遇到null访问栈顶
 * 3、访问栈顶右子树
 * 重复上述操作，直到栈和current都为null
 */
public class PreOrderTraversal {

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

    /**
     * 递归
     *
     * @param head
     */
    public void solution1(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        solution1(head.left);
        solution1(head.right);
    }

    /**
     * 非递归
     *
     * @param head
     */
    public void solution2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.data);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
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
                System.out.println(current.data);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        Node head = preOrderTraversal.init();
        // preOrderTraversal.solution1(head);
        //preOrderTraversal.solution2(head);
        preOrderTraversal.solution3(head);
    }

}
