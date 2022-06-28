/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:45 下午 2022/6/27
 **/


package org.example.bytedance.six27;


import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
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
        String path = "";
        dfs(result, path, n, 0, 0);
        return result;
    }

    private void dfs(List<String> result, String path, int n, int openCount, int closeCount) {
        if (openCount > n) {
            return;
        }
        if (closeCount > openCount) {
            return;
        }
        if (closeCount + openCount == 2 * n) {
            result.add(path);
            return;
        }
        dfs(result, path + "(", n, openCount + 1, closeCount);
        dfs(result, path + ")", n, openCount, closeCount + 1);
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
