/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:53 下午 2022/6/8
 **/


package org.example.math;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntReverse {

    /**
     * 转换为字符串做
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) == '-') {
            sb.append(str.substring(1));
        } else {
            sb.append(str);
        }
        sb.reverse();
        if (str.charAt(0) == '-') {
            sb.insert(0, '-');
        }
        long result = Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /**
     * 取模，取余算法
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MIN_VALUE / 10 && last > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && last < -8) {
                return 0;
            }
            res = res * 10 + last;
        }
        return res;
    }
}
