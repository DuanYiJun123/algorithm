/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:21 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import java.util.Stack;

public class MinStack {


    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            int peek=minStack.peek();
            peek= Math.min(peek,val);
            minStack.push(peek);
        }else{
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
