/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:14 下午 2022/6/7
 **/


package org.example.dp;

/**
 * 动态规划 爬楼梯
 * <p>
 * 一共N阶楼梯，一次只能上一到两阶，求有多少种不同的爬法
 */
public class ClimbingStairs {
    // n =1 ->1 1种
    // n =2 ->2 2种（11，2）
    // n =3 ->3 3种（111，12，21）
    // n =4 ->5 5种（1111，112，121，211，22）
    // n =5 ->8 8种（11111，1112，1121，1211，2111，221，212，122）

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int solutions1(int n) {
        if (n < 3) {
            return n;
        }
        return solutions1(n - 1) + solutions1(n - 2);
    }

    /**
     * 时间复杂度 ON
     *
     * @param n
     * @return
     */
    public int solutions2(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    /**
     * 解决时间复杂度的同时，解决了空间复杂度
     *
     * @param n
     * @return
     */
    public int solution3(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            //滚动数组
            steps[i % 3] = steps[(i - 1) % 3] + steps[(i - 2) % 3];
        }
        return steps[(n - 1) % 3];
    }

}
