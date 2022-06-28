/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:22 下午 2022/6/19
 **/


package actualcombat.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubString {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubString longestSubString = new LongestSubString();
        // int i = longestSubString.lengthOfLongestSubString(s);
        int i = longestSubString.solution2(s);
        System.out.println(i);
    }


    public int solution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int max=0;
        int left=0;
        return max;
    }

}
