/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:55 下午 2022/6/12
 **/


package org.example.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {4, 23, 54, 13, 76, 32, 89, 44, 4, 5, 23, 65};
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int index = 0;
        while (index < array.length - 1) {
            int minIndex = index + 1;
            for (int i = index; i < array.length; i++) {
                int temp = array[i];
                if (array[minIndex] > temp) {
                    minIndex = i;
                }
            }
            int temp;
            temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
            index++;
        }
    }
}
