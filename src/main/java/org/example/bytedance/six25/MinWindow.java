/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 1:25 下午 2022/6/25
 **/


package org.example.bytedance.six25;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {

    //滑动窗口的原理来实现
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Map<Character, Integer> oMap = new HashMap<>();
        Map<Character, Integer> cMap = new HashMap<>();

        int left = 0;
        int right = -1;

        int mleft = 0;
        int mright = -1;

        int min = Integer.MAX_VALUE;

        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            if (!oMap.containsKey(c)) {
                oMap.put(c, 1);
            } else {
                Integer integer = oMap.get(c);
                oMap.put(c, ++integer);
            }
        }

        while (right < s.length()) {
            right++;
            if (right < s.length() && oMap.containsKey(s.charAt(right))) {
                if (cMap.containsKey(s.charAt(right))) {
                    Integer integer = cMap.get(s.charAt(right));
                    integer++;
                    cMap.put(s.charAt(right), integer);
                } else {
                    cMap.put(s.charAt(right), 1);
                }
            }
            while (checked(oMap, cMap)) {
                int m = right - left;
                if (m < min) {
                    mleft = left;
                    mright = right;
                    min = m;
                }

                if (oMap.containsKey(s.charAt(left))) {
                    Integer integer = cMap.get(s.charAt(left));
                    integer--;
                    cMap.put(s.charAt(left), integer);
                }
                left++;
            }
        }
        return s.substring(mleft, mright + 1);
    }

    private boolean checked(Map<Character, Integer> oMap, Map<Character, Integer> cMap) {

        Set<Character> characters = oMap.keySet();
        for (Character c : characters) {
            if (!cMap.containsKey(c) || cMap.get(c) < oMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow.minWindow(s, t);
        System.out.println(s1);
    }
}
