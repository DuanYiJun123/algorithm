/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:26 下午 2022/7/4
 **/


package org.example.bit;

/**
 * 一个数组中有一种数出现了K次，其他数都出现了M次
 * M>1,K<M
 * 找到，出现了K次的数
 * 要求，空间复杂度O1，时间复杂度ON
 * <p>
 * <p>
 * 解法思路 ：借助一个长度的32位的数组，然后将数组中的每个数展开为二进制，对应每一位上为1的话，就累加到该32位长的数组上去。最后看该数组的每一位的数字
 * 若该数字是M的整数倍，则一定不是K的数字，若该数字是M的整数倍，则该位对应的K的数字的一定也是1
 */
public class FindKNum {

    //需要保障arr中只有一种数出现了k次，其他都出现了M次
    public static int solution(int[] array, int K, int M) {
        //tem[0] 0位置的1出现了几个
        //tem[1] 1位置出现了几个
        int[] tem = new int[32];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= 31; j++) {
                //依次提取出每位上的非0数字   向右移动j位与上1不等于0，即表示j位是1
                if ((array[i] >> j & 1) != 0) {
                    tem[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < tem.length; i++) {
            if (tem[i] % M == 0) {
                //说明K数在第i位置上不为1
            } else {
                //说明K数在第i位置上是1
                ans |= (1 << i);   //将1或到第i位置上
            }
        }
        return ans;
    }
}
