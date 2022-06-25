/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:48 下午 2022/6/18
 **/


package actualcombat.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void bubble(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmep = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmep;
                }
            }
        }
    }
}
