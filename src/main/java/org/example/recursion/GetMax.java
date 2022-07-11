/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:50 上午 2022/7/8
 **/


package org.example.recursion;

import java.util.TreeMap;

/**
 * 给一个数组arr,用递归的方式将数组中的最大元素找出来
 * <p>
 * 思路：为了更好的理解递归，不用for循环的方式。
 * 先找到数组的中点范围M，然后找左 到中点的最大值，然后找右到中点的最大值，然后比较两个最大值，取最大
 */
public class GetMax {

    public int solution(int[] array) {
        int left = 0;
        int right = array.length - 1;
        return process(0, right, array);
    }

    public int process(int left, int right, int[] array) {
        if (left == right) {
            return array[left];
        }
        int mid = left + (right - left) / 2;
        int maxLeft = process(left, mid, array);
        int maxRight = process(mid + 1, right, array);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        GetMax getMax = new GetMax();
        int[] array = {2, 56, 12, 43, 78, 33, 45, 90, 13, 45};
        int solution = getMax.solution(array);
        System.out.println(solution);
    }
}
