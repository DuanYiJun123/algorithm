/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:45 上午 2022/6/13
 **/


package org.example.random;

import org.example.sort.Bubble;
import org.example.sort.InsertSort;

/**
 * 对数器：生成随机样本做比对的机器。可以脱离线上数据，本地进行调试
 * 下面的例子即为随机生成数组，验证两个排序算法排序结果是否一致
 */
public class RandomValid {

    //生成一个数组长度为0——maxLen 数组元素为 0——maxValue的数组
    public static int[] generateArray(int maxLenth, int maxValue) {
        int length = (int) (Math.random() * maxLenth);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    //验证数组是否已经被排好序
    public static boolean sorted(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (max > array[i]) {
                return false;
            }
            max = array[i];
        }
        return true;
    }

    public static boolean arrayEqual(int[] array, int[] array1) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int maxLenth = 50;
        int maxValue = 10000;
        int[] array = generateArray(maxLenth, maxValue);
        int[] array1 = copyArray(array);
        Bubble bubble = new Bubble();
        bubble.bubbleSort(array);
        InsertSort.insertSort1(array1);

        if (!sorted(array)) {
            System.out.println("排序错误了");
        }

        if(!arrayEqual(array,array1)){
            System.out.println("俩个排序结果不一致");
        }
    }
}
