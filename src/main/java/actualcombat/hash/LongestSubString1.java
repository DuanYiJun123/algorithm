/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:25 下午 2022/6/27
 **/


package actualcombat.hash;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LongestSubString1 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str = "pwwkew";
        String str2 = "bbbbb";
        LongestSubString1 longestSubString1 = new LongestSubString1();
        int i = longestSubString1.lengthOfLongestSubstring(str2);
        System.out.println(i);
    }
}
