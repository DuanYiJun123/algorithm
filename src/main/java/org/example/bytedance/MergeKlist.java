/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:04 上午 2022/6/22
 **/


package org.example.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKlist {

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

    public ListNode merge(ListNode[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        for (int i = 0; i < array.length; i++) {
            ListNode listNode = array[i];
            while (listNode != null) {
                priorityQueue.offer(listNode);
                listNode = listNode.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        ListNode current = head;
        while (!priorityQueue.isEmpty()) {
            current = priorityQueue.poll();
            current.next=null;
            prev.next = current;
            prev = current;
        }
        return head.next;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(3);
//        ListNode listNode2 = new ListNode(5);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(6);
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode listNode = new ListNode(-2);
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(-1);
        ListNode listNode3 = new ListNode(-1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;



        ListNode[] array = new ListNode[2];
        array[0] = listNode;
        array[1] = null;

        MergeKlist mergeKlist = new MergeKlist();
        ListNode merge = mergeKlist.merge(array);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

}
