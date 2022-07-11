/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:36 上午 2022/7/5
 **/


package org.example.linked;

import org.example.bytedance.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (current.val == val) {
                prev.next = next;
                current = next;
            } else {
                prev = current;
                current = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(5);
        ListNode head3 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        DeleteNode deleteNode = new DeleteNode();
        ListNode listNode = deleteNode.deleteNode(head, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
