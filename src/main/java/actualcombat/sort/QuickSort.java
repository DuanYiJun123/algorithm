/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:37 下午 2022/6/18
 **/


package actualcombat.sort;


public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        quickSort.quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    public void process(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int pivot = array[left];
        while (left < right) {
            while (array[right] >= pivot && left < right) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (array[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
            if (left == right) {
                array[left] = pivot;
            }
        }
        process(array, l, left - 1);
        process(array, right + 1, r);
    }


}
