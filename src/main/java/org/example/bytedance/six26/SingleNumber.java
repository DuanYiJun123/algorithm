/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:55 下午 2022/6/26
 **/


package org.example.bytedance.six26;

/**
 * 获取一个数组中，仅出现一次的数字。 进阶，不使用额外的储存空间
 */
public class SingleNumber {

    //使用异或的方法，异或即相同的数字异或会变成0，0与不为0的数字异或，结果为该数字
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

}
