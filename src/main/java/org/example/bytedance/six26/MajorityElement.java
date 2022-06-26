/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:48 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 3, 3, 3};
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(array);
        System.out.println(i);
    }

}
