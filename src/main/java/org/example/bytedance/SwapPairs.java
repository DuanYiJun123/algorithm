/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:02 下午 2022/6/25
 **/


package org.example.bytedance;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode first = head;
        ListNode second = head.next;

        while (first != null && second != null) {
            ListNode next = second.next;
            first.next = next;
            second.next = first;
            pre.next = second;
            if (next == null) {
                break;
            }
            pre = first;
            first = next;
            second = next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode5 = swapPairs.swapPairs(listNode);

        while (listNode5 != null) {
            System.out.println(listNode5.val);
            listNode5 = listNode5.next;
        }
    }

}
