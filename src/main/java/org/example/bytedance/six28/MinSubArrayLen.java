/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:29 上午 2022/6/28
 **/


package org.example.bytedance.six28;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int min = nums.length;
        int sum = 0;
        boolean flag = false;
        while (end < nums.length) {
            while (end < nums.length && sum < target) {
                sum = sum + nums[end];
                end++;
            }
            while (sum >= target) {
                sum = sum - nums[start];
                min = Math.min(min, end - start);
                start++;
                flag = true;
            }
            if (!flag) {
                return 0;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        int[] array2 = {1, 4, 4};
        int[] array3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        int target2 = 4;
        int target = 7;
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int i = minSubArrayLen.minSubArrayLen(target3, array3);
        System.out.println(i);
    }
}
