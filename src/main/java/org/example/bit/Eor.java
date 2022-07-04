/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:35 下午 2022/7/4
 **/


package org.example.bit;

/**
 * 一个数组中，某数出现了奇数次，其他数均出现了偶数次，求该奇数次的数
 *
 * 解法：异或即可。因为偶数次的数字用0异或还等于0
 */
public class Eor {

    public static void printOddTimesNums1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
}
