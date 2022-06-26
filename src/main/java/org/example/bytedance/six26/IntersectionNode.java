/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:29 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import org.example.bytedance.ListNode;

import java.util.HashSet;

import java.util.Set;

/**
 * 相交链表
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
