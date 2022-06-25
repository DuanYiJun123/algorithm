/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:01 上午 2022/6/20
 **/


package actualcombat.binarySearch;

public class SearchInRotated {

    public int search(int[] num, int target) {
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > num[start]) {
                if (target < num[mid] && target > num[start]) {
                    mid = end;
                } else {
                    mid = start;
                }
            }
            if (num[mid] < num[start]) {
                if (target > num[mid] && target < num[end]) {
                    mid = start;
                } else {
                    mid = end;
                }
            }
        }
        if (target == num[start]) {
            return start;
        }
        if (target == num[end]) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
