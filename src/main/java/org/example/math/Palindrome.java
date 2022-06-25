/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:19 下午 2022/6/8
 **/


package org.example.math;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {

    /**
     * 通过字符串来解
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        String result = sb.toString();
        if (str.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 非字符串解法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int origi = x;
        int res = 0;
        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            res = res * 10 + last;
        }
        return res == origi;
    }

}
