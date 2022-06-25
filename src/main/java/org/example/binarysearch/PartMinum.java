/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:54 下午 2022/6/13
 **/


package org.example.binarysearch;

/**
 * 局部最小  一个无序数组，相邻元素不相等。 求任意一个局部最小元素。局部最小定义 1、最左边的数 [0]<[1] 2、最右边的数[N-2]>[N-1] 3、[i-1]>[i]<[i+1]
 */
public class PartMinum {

    public static int getIndex(int[] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;

        if (array[0] < array[1]) {
            return 0;
        }

        if (array[end] < array[end - 1]) {
            return end;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < array[mid - 1]) {
                start = mid;
            }
            if (array[mid] > array[mid - 1]) {
                end = mid;
            }
        }
        return array[start] < array[end] ? start : end;
    }

    public static void main(String[] args) {
        int[] array = {3,2,3,2,3};
        int index = getIndex(array);
        System.out.println(index);
    }


}
