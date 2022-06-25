/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:00 上午 2022/6/22
 **/


package org.example.bytedance;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = nums[0];
                pre = nums[0];
            } else {
                pre = Math.max(nums[i], pre + nums[i]);
                max = Math.max(max, pre);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] nums = {1};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }
}
