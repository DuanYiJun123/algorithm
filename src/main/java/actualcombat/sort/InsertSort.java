/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:55 下午 2022/6/18
 **/


package actualcombat.sort;

public class InsertSort {

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        insertSort.insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index >= 1 && array[index - 1] > array[index]) {
                int temp = array[index - 1];
                array[index - 1] = array[index];
                array[index] = temp;
                index--;
            }
        }
    }


//    public void insertSort(int[] array) {
//        if (array == null || array.length < 2) {
//            return;
//        }
//        for (int i = 1; i < array.length; i++) {
//            int index = i;
//            while (index - 1 >= 0 && array[index - 1] > array[index]) {
//                int tmep = array[index - 1];
//                array[index - 1] = array[index];
//                array[index] = tmep;
//                index--;
//            }
//        }
//    }
}
