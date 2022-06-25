/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:23 下午 2022/6/24
 **/


package org.example.bytedance.week1;

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

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        String temp = "";
        int open = 0;
        int close = 0;
        dfs(open, close, temp, result, n);
        return result;
    }

    private void dfs(int open, int close, String temp, List<String> result, int n) {
        if (open > n || open < close) {
            return;
        }
        if (temp.length() == n * 2) {
            result.add(temp);
            return;
        }
        dfs(open + 1, close, temp + "(", result, n);
        dfs(open, close + 1, temp + ")", result, n);
    }
}
