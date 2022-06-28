/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:18 上午 2022/6/27
 **/


package org.example.bytedance.six27;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n)的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] array = new int[2];
        array[0] = -1;
        array[1] = -1;
        if (nums == null || nums.length == 0) {
            return array;
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                array[0] = 0;
                array[1] = 0;
                return array;
            }
        }
        int start = 0;
        int end = nums.length - 1;
        boolean fundStart = false;
        boolean fundEnd = false;
        while (start <= end && (!fundStart || !fundEnd)) {
            if (nums[start] == target && !fundStart) {
                array[0] = start;
                fundStart = true;
            }
            if (nums[end] == target && !fundEnd) {
                array[1] = end;
                fundEnd = true;
            }
            if (nums[start] < target) {
                start++;
            }
            if (nums[end] > target) {
                end--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1,3};
        int target = 1;
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(array, target);
        System.out.println(ints[0] + " " + ints[1]);
    }
}
