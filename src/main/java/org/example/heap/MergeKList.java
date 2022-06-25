/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:42 下午 2022/6/14
 **/


package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                }
                if (o1.val > o2.val) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                priorityQueue.add(list);
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        if (pre.next != null) {
            priorityQueue.add(pre.next);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            pre.next = poll;
            pre = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        MergeKList mergeKList = new MergeKList();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        ListNode[] array = new ListNode[2];
        array[0] = listNode;
        array[1] = listNode2;
        ListNode listNode1 = mergeKList.mergeKLists(array);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
