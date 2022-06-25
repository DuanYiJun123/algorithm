/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:34 下午 2022/6/7
 **/


package org.example.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * copy list with random pointer
 * 深度拷贝带有随机指针的链表
 */
public class DeepCopyWithRandom {

    public static Map<Node, Node> map = new HashMap<>();

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int data) {
            this.val = data;
        }
    }

    public static void init() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
    }

    public static void showList(Node head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node deepCopy(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = head;
        while (dummy != null) {
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null) {
            Node node = map.get(dummy);
            if (dummy.random != null) {
                node.random = map.get(dummy.random);
            }
            node.next = map.get(dummy.next);
            dummy = dummy.next;
        }
        return head;

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }
    public void copy(Node head){
        Node node=head;
        while(node!=null){
            Node copy=new Node(node.val);
            copy.next=node.next;
            node.next=copy;
            node=copy.next;
        }
    }
    public void copyRandom(Node head){
        Node node=head;
        while(node!=null&&node.next!=null){
            if(node.random!=null){
                node.next.random=node.random.next;
            }
            node=node.next.next;
        }
    }

    public Node split(Node head){
        Node result=head.next;
        Node move=head.next;
        while(head!=null&&head.next!=null){
            head.next=head.next.next;
            head=head.next;
            if(move!=null&&move.next!=null){
                move.next=move.next.next;
                move=move.next;
            }
        }
        return result;
    }


}
