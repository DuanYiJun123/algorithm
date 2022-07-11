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

    //非递归方法实现
    public void mergeSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int N = array.length;
        //步长
        int mergeSize = 1;
        while (mergeSize < N) {
            //当前左组的第一个位置
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);
                merge(array, L, R, M);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            //步长乘2
            mergeSize <<= 1;
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
