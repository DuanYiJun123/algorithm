/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:07 下午 2022/6/25
 **/


package org.example.bytedance;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    //动态规划解法  一个回文串，去掉两头的字符，中间的串也一定是回文的
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
        }
        int length = s.length();
        //二位数组，下标为子串的起始位置和终态位置，表示两位置下，是否为回文串
        boolean[][] dp = new boolean[length][length];
        //dp[i][j] 的状态取决于 它两头的元素 i,j是否相等，且 dp[i+1][j-1] 是否为回文串

        //下标元素相等的单个元素，均为回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 3) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if ((j - i) > maxLength) {
                        maxStart = i;
                        maxEnd = j;
                        maxLength = maxEnd - maxStart;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String babad = longestPalindrome.longestPalindrome("babad");
        System.out.println(babad);

    }
}
