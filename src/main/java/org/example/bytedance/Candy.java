/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:51 下午 2022/6/23
 **/


package org.example.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        if (ratings.length == 2 && ratings[0] != ratings[1]) {
            return 3;
        }
        if (ratings.length == 2 && ratings[0] == ratings[1]) {
            return 2;
        }
        int max = 0;
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            leftMap.put(i, 1);
        }
        //从左向右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                Integer integer = leftMap.get(i - 1);
                leftMap.put(i, ++integer);
            }
        }
        //从右向左
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                Integer integer = leftMap.get(i - 1);
                Integer integer1 = leftMap.get(i);
                int temp = Math.max(integer, ++integer1);
                leftMap.put(i - 1, temp);
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            Integer integer = leftMap.get(i);
            max = max + integer;

        }
        return max;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] arrya = {1, 0,2};
        int candy1 = candy.candy(arrya);
        System.out.println(candy1);
    }
}
