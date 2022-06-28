/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:43 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import java.util.Arrays;

/**
 * 给一个数组，可以使用数组中的元素，组合成为最接近Limit 数值的结果。求该结果
 */
public class LimitArray {

    public static int maxNumber(int[] array, int limit) {
        //array里面是不重复的数字
        Arrays.sort(array);
        limit--;

        int offset = 1;
        //这段代码，是让offset的长度和limit的长度保持一致
        while (offset <= limit / 10) {
            offset *= 10;
        }

        //可以使用Limit的数字，期望得到尽可能接近limit的结果，并且位数一样。如果返回结果位数小于Limit，则返回-1
        int ans = process(array, limit, offset);
        if (ans != -1) {
            return ans;
        } else {
            //位数做不到和Limit位数一样，则直接减少一位，返回最大的数字组成的数字
            offset /= 10;
            int rest = 0;
            while (offset > 0) {
                rest += array[array.length - 1] * offset;
                offset /= 10;
            }
            return rest;
        }
    }

    private static int process(int[] array, int limit, int offset) {
        //之前的数字和Limit完全一样，且Limit所有数字都一样
        if (offset == 0) {
            return limit;
        }
        //获取当前位数的数字
        int cur = (limit / offset) % 10;
        //获取array中最接近cur的数组的下标
        int near = near(array, cur);
        if (near == -1) {
            return -1;
        } else if (array[near] == cur) {  //当前位置找出来的数字，和cur数字一致
            int ans = process(array, limit, offset / 10);
            if (ans != -1) {
                return ans;
            } else if (near > 0) {//虽然后续没成功，但我自己还能下降！还能选更小的数字
                near--;
                return (limit / (offset * 10)) * offset * 10 + (array[near] * offset);
            } else {//后续没成功，我自己也不能再下降了，宣告失败，向上返回
                return -1;
            }
        } else {
            return (limit / (offset * 10)) * offset * 10 + (array[near] * offset);
        }
    }

//    private static int rest(int[] array, int offset) {
//
//
//    }

    private static int near(int[] array, int cur) {
        for (int i = array.length - 1; i > 0; i++) {
            if (array[i] < cur) {
                return i;
            }
        }
        return -1;
    }
}
