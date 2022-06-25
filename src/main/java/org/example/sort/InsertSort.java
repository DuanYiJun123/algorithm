/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:53 下午 2022/6/10
 **/


package org.example.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        int insertNode;
        for (int i = 1; i < array.length; i++) {
            insertNode = array[i];
            int j = i - 1;
            while (j >= 0 && insertNode < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNode;
        }
    }

    public static void insertSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length - 1; i++) {
            int insertIndex = i + 1;
            while (insertIndex > 0 && array[insertIndex] < array[insertIndex - 1]) {
                int temp = 0;
                temp = array[insertIndex];
                array[insertIndex] = array[insertIndex - 1];
                array[insertIndex - 1] = temp;
                insertIndex--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        //insertSort(array);
        insertSort1(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}
