/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:55 下午 2022/6/24
 **/


package org.example.bytedance.week1;

import org.example.bytedance.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReArrangeLinkedList {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ReArrangeLinkedList reArrangeLinkedList = new ReArrangeLinkedList();
        ListNode listNode = reArrangeLinkedList.reorderList(listNode0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode reorderList(ListNode head) {
        ListNode dumy = head;
        ListNode middle = getMiddle(head);
        ListNode end = reverse(middle);
        while (end != null) {
            ListNode leftNext = head.next;
            ListNode rightNext = end.next;
            head.next = end;
            end.next = leftNext;
            head = leftNext;
            end = rightNext;
        }
        return dumy;
    }


    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


}
