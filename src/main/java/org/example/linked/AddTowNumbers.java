/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:38 下午 2022/6/8
 **/


package org.example.linked;

/**
 * 两个链表的数相加 例如 2-4-3   5-6-4  相加得7-0-8
 */
public class AddTowNumbers {

    public static class ListNode {

        int val;

        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode init1() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public static ListNode init2() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public static void showList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int addOne = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + addOne;
            addOne = total / 10;
            int val = total % 10;
            ListNode newNode = new ListNode(val);
            dummy.next = newNode;
            dummy = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int total = l1.val + addOne;
            addOne = total / 10;
            int val = total % 10;
            ListNode newNode = new ListNode(val);
            dummy.next = newNode;
            dummy = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int total = l2.val + addOne;
            addOne = total / 10;
            int val = total % 10;
            ListNode newNode = new ListNode(val);
            dummy.next = newNode;
            dummy = newNode;
            l2 = l2.next;
        }
        if (addOne != 0) {
            ListNode newNode = new ListNode(addOne);
            dummy.next = newNode;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = init1();
        ListNode l2 = init2();
        ListNode node = addTwoNumbers(l1, l2);
        showList(node);
    }
}
