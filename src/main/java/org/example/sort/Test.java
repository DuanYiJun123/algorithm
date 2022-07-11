/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:03 下午 2022/7/8
 **/


package org.example.sort;

public class Test {

    public static int solution(int[] array) {
        int left = 0;
        int right = array.length - 1;
        return process(array, left, right);
    }

    private static int process(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int mid = left + (right - left) / 2;
        return process(array, mid + 1, right) + process(array, left, mid);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int solution = solution(array);
        System.out.println(solution);
    }
}
