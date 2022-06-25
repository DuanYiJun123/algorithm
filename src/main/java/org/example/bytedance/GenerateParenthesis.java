/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:31 上午 2022/6/23
 **/


package org.example.bytedance;

import java.util.ArrayList;
import java.util.List;


/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);

    }

    public List<String> generateParenthesis(int n) {
        List<String> temp = new ArrayList<>();
        String path = "";
        int open = 0;
        int close = 0;
        dfs(n, path, temp, open, close);
//        for (String str : temp) {
//            if (validate(str)) {
//                result.add(str);
//            }
//        }
        return temp;
    }


    private void dfs(int n, String path, List<String> temp, int open, int close) {
        if (open > n || open < close) {
            return;
        }
        if (path.length() == 2 * n) {
            temp.add(path);
            return;
        }
        dfs(n, path + "(", temp, open + 1, close);
        dfs(n, path + ")", temp, open, close + 1);
    }

//    public boolean validate(String str) {
//        if (str == null || str.length() == 0) {
//            return true;
//        }
//        char[] chars = str.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '(') {
//                stack.push(chars[i]);
//            }
//            if (chars[i] == ')') {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                Character pop = stack.pop();
//                if (!pop.equals('(')) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

}
