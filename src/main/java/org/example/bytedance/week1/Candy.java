/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:34 下午 2022/6/24
 **/


package org.example.bytedance.week1;

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
        int max = 0;
        if (ratings == null || ratings.length == 0) {
            return max;
        }
        if (ratings.length == 1) {
            return 1;
        }

        if (ratings.length == 2) {
            if (ratings[0] == ratings[1]) {
                return 2;
            } else {
                return 3;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            map.put(i, 1);
        }

        //从左到右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                Integer integer = map.get(i-1);
                integer++;
                map.put(i, integer);
            }
        }

        //从右到左
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                Integer integer = map.get(i);
                Integer integer1 = map.get(i - 1);
                int max1 = Math.max(++integer, integer1);
                map.put(i - 1, max1);
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            max = max + map.get(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arrya = {1, 2, 87, 87, 2, 1};
        Candy candy = new Candy();
        int candy1 = candy.candy(arrya);
        System.out.println(candy1);
    }
}
