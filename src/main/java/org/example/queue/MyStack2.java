/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:22 下午 2022/7/5
 **/


package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        }
        if (!queue2.isEmpty()) {
            queue2.offer(x);
        }
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

        if (!queue2.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }

        throw new RuntimeException("empty");
    }

    public static void main(String[] args) {
        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        System.out.println(stack2.pop());

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }
}
