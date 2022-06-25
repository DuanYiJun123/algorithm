/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:45 上午 2022/6/14
 **/


package org.example.linked;

/**
 * 给一链表，和一个常数k，将链表的节点按K个一组进行分组，组内进行反转，不够k个的则不用管
 * 例如 1->2->3->4->5->6->7->8 k=3  得到结果 3->2->1->6->5->4->7->8
 */
public class GroupReverse {

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
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        return node0;
    }

    public static Node solution(Node head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 2) {
            return head;
        }
        Node start = head;
        Node end = getEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        Node lasEnd = start;
        while (lasEnd.next != null) {
            start = lasEnd.next;
            end = getEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lasEnd.next = end;
            lasEnd = start;
        }
        return head;
    }

    public static void reverse(Node start, Node end) {
        end = end.next;
        Node prev = null;
        Node current = start;
        Node next = null;
        while (current != end) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start.next = end;
    }

    public static Node getEnd(Node start, int k) {
        while (k > 1 && start != null) {
            start = start.next;
            k--;
        }
        return start;
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

    public static void main(String[] args) {
        Node head = init();
        Node solution = solution(head, 3);
        showList(solution);
    }
}
