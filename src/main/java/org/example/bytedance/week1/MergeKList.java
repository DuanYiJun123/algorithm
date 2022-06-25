/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:40 上午 2022/6/24
 **/


package org.example.bytedance.week1;


import org.example.bytedance.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKList {

    public ListNode merge(ListNode[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < array.length; i++) {
            ListNode current = array[i];
            while (current != null) {
                priorityQueue.offer(current);
                current = current.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        ListNode current = head;
        while (!priorityQueue.isEmpty()) {
            current = priorityQueue.poll();
            pre.next = current;
            current.next = null;
            pre = current;
        }
        return head.next;
    }
}
