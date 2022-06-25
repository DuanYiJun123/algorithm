/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:49 下午 2022/6/9
 **/


package org.example.twopointer;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class ValidTriangle {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            int start = 0;
            for (int i = k - 1; i > 0; i--) {
                while (start < i) {
                    if (nums[start] + nums[i] <= nums[k]) {
                        start++;
                    } else {
                        total = total + i - start;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arryay = {2, 2, 3, 4};
        ValidTriangle validTriangle = new ValidTriangle();
        int i = validTriangle.triangleNumber(arryay);
        System.out.println(i);
    }
}
