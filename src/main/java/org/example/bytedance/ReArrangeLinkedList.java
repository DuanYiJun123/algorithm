/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:31 下午 2022/6/22
 **/


package org.example.bytedance;

import java.util.List;

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

    public ListNode reorderList(ListNode head) {
        ListNode node = head;
        //先通过快慢指针找到中点
        ListNode midlleNode = findMidNode(node);
        //然后对中点右边的链表进行反转
        ListNode resNode = reverseNode(midlleNode);
        ListNode left = head;
        ListNode right = resNode;
        while (right.next != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
        return head;
    }

    public ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
