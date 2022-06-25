/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:20 上午 2022/6/21
 **/


package org.example.bytedance;

public class MaxWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int leftHigh = height[start];
            int rightHigh = height[end];
            max = Math.max(((end - start) * Math.min(leftHigh, rightHigh)), max);
            if (leftHigh < rightHigh) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
