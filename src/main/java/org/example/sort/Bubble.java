/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:26 下午 2022/6/10
 **/


package org.example.sort;

/**
 * 冒泡排序
 */
public class Bubble {

    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        Bubble bubble = new Bubble();
        bubble.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
