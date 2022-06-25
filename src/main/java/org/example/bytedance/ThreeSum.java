/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:48 下午 2022/6/25
 **/


package org.example.bytedance;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] >= 0) {
                break;
            }
            int num = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                List<Integer> temp = new ArrayList<>();
                if (num + nums[start] + nums[end] == 0) {
                    temp.add(num);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    end--;
                    start++;
                }
                if (num + nums[start] + nums[end] > 0) {
                    end--;
                }
                if (num + nums[start] + nums[end] < 0) {
                    start++;
                }
                if (!temp.isEmpty()) {
                    resultSet.add(temp);
                }
            }

        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(array);
    }
}
