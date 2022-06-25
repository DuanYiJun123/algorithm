/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:40 下午 2022/6/10
 **/


package org.example.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void qsort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        sort(left, right, array);
    }

    public static void sort(int L, int R, int[] array) {
        if (L >= R) {
            return;
        }
        int left = L;
        int right = R;
        int pvoit = array[left];
        while (left < right) {
            while (left < right && pvoit <= array[right]) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && pvoit >= array[left]) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
            if (left >= right) {
                array[left] = pvoit;
            }
        }
        sort(L, right, array);
        sort(right + 1, R, array);
    }

    public static void main(String[] args) {
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2,321,45,68,999,2342,543,123};
        qsort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
