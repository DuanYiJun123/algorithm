/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:42 下午 2022/6/11
 **/


package org.example.bit;

/**
 * 左移一位，等于10进制乘以2
 * <p>
 * 一个整型32位 最高位是符号位
 * MAX.INTVALUE = 2^31-1
 * MIN.INTVALUE = -2^31
 */
public class BitTest {

    /**
     * 打印出一个整形数字32位
     */
    public static void printInt(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int minValue = Integer.MIN_VALUE;

        printInt(minValue);
    }
}
