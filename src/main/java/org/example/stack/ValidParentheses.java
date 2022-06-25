/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:45 下午 2022/6/8
 **/


package org.example.stack;

import java.util.Stack;

/**
 * 括号验证
 */
public class ValidParentheses {

    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                Character pop = stack.pop();
                if (!pop.equals('(')) {
                    return false;
                }
            }
            if (c == ']') {
                Character pop = stack.pop();
                if (!pop.equals('[')) {
                    return false;
                }
            }
            if (c == '}') {
                Character pop = stack.pop();
                if (!pop.equals('{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String str = "[";
        System.out.println(validParentheses.isValid(str));
    }

}
