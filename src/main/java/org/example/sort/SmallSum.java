/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:18 下午 2022/7/8
 **/


package org.example.sort;

/**
 * 小和问题，给一个数组，求出数组中每个元素左边比其小的元素的和，最后将这些和相加，求出最后的总和
 * <p>
 * 例如 数组 [6,3,2,1,6,7]  对应元素左边小于该元素的和分别是 0，0,0,0,6,18  最后的结果是24
 * <p>
 * 请不要使用时间复杂度为O（N）平方的方法解决此问题
 */
public class SmallSum {

    public int solution(int[] array) {
        if (array == null) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        return process(array, left, right);
    }

    private int process(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return process(array, left, mid) + process(array, mid + 1, right) + merge(array, left, right, mid);
    }

    private int merge(int[] array, int left, int right, int mid) {
        int result = 0;
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int[] newArray = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (array[p1] < array[p2]) {
                result += (right - p2 + 1) * array[p1];
                newArray[index++] = array[p1++];
            } else {
                newArray[index++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            newArray[index++] = array[p1++];
        }
        while (p2 <= right) {
            newArray[index++] = array[p2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            array[left + i] = newArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SmallSum smallSum = new SmallSum();
        int[] array = {6, 3, 2, 1, 6, 7};
        int solution = smallSum.solution(array);
        System.out.println(solution);
    }
}
