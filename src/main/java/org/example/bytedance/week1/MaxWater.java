/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:32 上午 2022/6/24
 **/


package org.example.bytedance.week1;

public class MaxWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int leftHight = height[start];
            int rightHight = height[end];
            max = Math.max(Math.min(leftHight, rightHight) * (end - start), max);
            if (leftHight < rightHight) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
