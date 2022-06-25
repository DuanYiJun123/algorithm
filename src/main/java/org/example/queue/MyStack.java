/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:09 下午 2022/6/8
 **/


package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        while (!queue1.isEmpty()) {
            Integer poll = queue1.poll();
            queue2.offer(poll);
        }
        queue1.offer(x);
        while (!queue2.isEmpty()) {
            Integer poll = queue2.poll();
            queue1.offer(poll);
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        }
        return 0;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        }
        return 0;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
