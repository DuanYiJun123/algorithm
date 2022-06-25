/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:44 上午 2022/6/24
 **/


package org.example.bytedance.week1;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(array);
        System.out.println(i);
    }
}
