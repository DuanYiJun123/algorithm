/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:22 下午 2022/6/7
 **/


package org.example.dp;

/**
 * 数组，不能连续相加，求数组中的最大和
 * 例如 input [1，2，3，1] output 1+3=4
 * input [2,7,9,3,1] output 2+9+1=12
 */
public class HouseRobber {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 1};
        int array2[] = {2, 7, 9, 3, 1};
        int solution = solution(array2);
        System.out.println(solution);
    }

    public static int solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] fn = new int[array.length];
        if (array.length == 1) {
            return array[0];
        }
        fn[0] = array[0];
        fn[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            fn[i] = Math.max(fn[i - 2] + array[i], fn[i - 1]);
        }
        return fn[fn.length - 1];
    }


}
