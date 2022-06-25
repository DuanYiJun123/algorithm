/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:17 下午 2022/6/9
 **/


package org.example.twopointer;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 存水问题
 *
 * 解题思路。双指针，从两头开始，比较两头高度，从较小的开始前进。若从左开始，则左+1的地方如果小于左高度，则此时可存水，存得的水量为左高度-左+1高度（因为左高度小于等于右高度）；右侧则同理
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int total = 0;
        int leftHight = height[start];
        int rightHight = height[end];
        while (start < end) {
            if (leftHight <= rightHight) {
                if (leftHight > height[start + 1]) {
                    total = total + leftHight - height[start + 1];
                } else {
                    leftHight = height[start + 1];
                }
                start++;
            }
            if (leftHight > rightHight) {
                if (rightHight > height[end - 1]) {
                    total = total + rightHight - height[end - 1];
                } else {
                    rightHight = height[end - 1];
                }
                end--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater=new TrappingRainWater();
        int trap = trappingRainWater.trap(array);
        System.out.println(trap);
    }

}
