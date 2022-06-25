/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:48 下午 2022/6/8
 **/


package org.example.stack;

import java.util.Stack;

/**
 * 最小栈,请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty()) {
            Integer peek = stack2.peek();
            stack2.push(Math.min(peek, x));
        } else {
            stack2.push(x);
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        return 0;
    }

    public int getMin() {
        return stack2.peek();
    }
}
