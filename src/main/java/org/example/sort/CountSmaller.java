/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:57 下午 2022/7/11
 **/


package org.example.sort;

import java.util.*;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSmaller {

    private int[] ans;

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> list = countSmaller.countSmaller(nums);
        System.out.println(list.toString());
    }



    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        this.ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        process(nums, left, right);
        for (int num : ans) {
            result.add(num);
        }
        return result;
    }

    private void process(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int[] newNums = new int[right - left + 1];

        int windowR = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (windowR <= right && nums[i] > nums[windowR]) {
                windowR++;
            }
            ans[i]=ans[i]+windowR-mid-1;
        }

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] > nums[p2]) {
                newNums[index++] = nums[p2++];
            } else {
                newNums[index++] = nums[p1++];
            }
        }

        while (p1 <= mid) {
            newNums[index++] = nums[p1++];
        }

        while (p2 <= right) {
            newNums[index++] = nums[p2++];
        }

        for (int i = 0; i < newNums.length; i++) {
            nums[left + i] = newNums[i];
        }
    }
}
