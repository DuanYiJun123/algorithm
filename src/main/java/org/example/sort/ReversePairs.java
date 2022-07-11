/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:19 上午 2022/7/11
 **/


package org.example.sort;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 1};
        ReversePairs reversePairs = new ReversePairs();
        int i = reversePairs.reversePairs(array);
        System.out.println(i);
    }

    public int reversePairs(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        return process(left, right, nums);
    }

    private int process(int left, int right, int[] nums) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return process(left, mid, nums) + process(mid + 1, right, nums) + merge(left, right, mid, nums);
    }

    private int merge(int left, int right, int mid, int[] nums) {
        int result = 0;
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int[] newArray = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                newArray[index++] = nums[p1++];
            } else {
                result += (mid - p1 + 1);
                newArray[index++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            newArray[index++] = nums[p1++];
        }
        while (p2 <= right) {
            newArray[index++] = nums[p2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            nums[left + i] = newArray[i];
        }

        return result;
    }
}
