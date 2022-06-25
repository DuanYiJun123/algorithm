/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:53 下午 2022/6/18
 **/


package actualcombat.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {4, 66, 23, 54, 12, 65, 33, 2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void mergeSort(int[] array) {
        process(array, 0, array.length - 1);
    }

    public void process(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        process(array, start, mid);
        process(array, mid + 1, end);
        merge(array, start, end, mid);
    }

    public void merge(int[] array, int start, int end, int mid) {
        int index1 = start;
        int index2 = mid + 1;
        int[] result = new int[end-start+1];
        int index = 0;
        while (index1 <= mid && index2 <= end) {
            if (array[index1] <= array[index2]) {
                result[index] = array[index1];
                index1++;
            } else {
                result[index] = array[index2];
                index2++;
            }
            index++;
        }
        while (index1 <= mid) {
            result[index] = array[index1];
            index++;
            index1++;
        }
        while (index2 <= end) {
            result[index] = array[index2];
            index++;
            index2++;
        }
        for (int i = 0; i < result.length; i++) {
            array[start+i] = result[i];
        }
    }
}
