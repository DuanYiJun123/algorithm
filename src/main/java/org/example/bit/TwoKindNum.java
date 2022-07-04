/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:49 下午 2022/7/4
 **/


package org.example.bit;

/**
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 * <p>
 * 解题思路：假设两个不同的数字分别是a,b。先全部和eor=0进行异或，得到的数字是a异或b，假定为c，然后找到c中一位为1的数，则a和b在该位上肯定一个为1一个为0。
 * <p>
 * 然后再用一个eor' 对 如果改位为1的情况进行异或，则能够找到a/b,然后再用eor和eor'进行异或，则找到另一个值
 */
public class TwoKindNum {

    public static void printOddTimesNum2(int[] array) {
        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor ^= array[i];
        }
        //eor =a^b
        //eor!=0;
        //eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1);//提取出最右侧的1
        int onlyOne = 0; //eor'
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & rightOne) != 0) {
                onlyOne ^= array[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
