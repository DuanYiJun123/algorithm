/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:05 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import org.example.bytedance.ListNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
