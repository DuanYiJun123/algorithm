/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:42 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import org.example.bytedance.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> vals = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            vals.add(current.val);
            current = current.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);

        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;

        PalindromeList palindromeList = new PalindromeList();
        boolean palindrome = palindromeList.isPalindrome(head);
        System.out.println(palindrome);
    }
}
