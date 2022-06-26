/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:15 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import java.util.Arrays;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
