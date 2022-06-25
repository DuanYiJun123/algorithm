/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:24 下午 2022/6/16
 **/


package org.example.sort;

/**
 * 归并排序  1、把数组一分为二  2、对两个数组左右分别进行排序  3、merge两个数组（生成一个新数组）
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 11, 56, 23, 6, 78, 32, 14, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public void mergeSort(int[] array) {
        if (array == null && array.length == 0) {
            return;
        }
        if (array.length == 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        process(array, start, end);

    }

    public void process(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        process(array, L, mid);
        process(array, mid + 1, R);
        merge(array, L, R, mid);
    }

    private void merge(int[] array, int l, int r, int mid) {
        int[] newArray = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (array[p1] <= array[p2]) {
                newArray[index++] = array[p1++];
            } else {
                newArray[index++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            newArray[index++] = array[p1++];
        }
        while (p2 <= r) {
            newArray[index++] = array[p2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            array[l + i] = newArray[i];
        }
    }


}
